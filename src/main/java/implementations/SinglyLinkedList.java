package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {

    private Node<E> head;
    private int size;

    private static class Node<E> {
        private E value;
        private Node<E> next;

        Node(E value) {
            this.value = value;
        }
    }

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public void addFirst(E element) {
        Node<E> toAdd = new Node<>(element);

        if (!isEmpty()) {
            toAdd.next = this.head;
        }
        this.head = toAdd;
        this.size++;
    }

    @Override
    public void addLast(E element) {
        Node<E> toAdd = new Node<>(element);

        if(isEmpty()) {
            this.head = toAdd;
        } else {
            Node<E> current = this.head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = toAdd;
        }
        this.size++;
    }

    @Override
    public E removeFirst() {
        ensureNonEmpty("Can not invoke removeFirst() on a empty list!");

        E value = this.head.value;
        this.head = this.head.next;
        this.size--;
        return value;
    }

    @Override
    public E removeLast() {
        ensureNonEmpty("Can not invoke removeLast() on a empty list!");

        if(this.size == 1) {
            E value = this.head.value;
            this.head = null;
            this.size--;
            return value;
        }

        Node<E> preLast = this.head;
        Node<E> toRemove = this.head.next;

        while (toRemove.next != null) {
                preLast = toRemove;
                toRemove = toRemove.next;
        }

        preLast.next = null;

        return toRemove.value;
    }

    @Override
    public E getFirst() {
        ensureNonEmpty("Can not invoke getFirst() on a empty list!");
        return this.head.value;
    }

    @Override
    public E getLast() {
        ensureNonEmpty("Can not invoke getLast() on a empty list!");
        Node<E> current = this.head;

        while (current.next != null) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    private void ensureNonEmpty(String message) {
        if (this.isEmpty()) {
            throw new IllegalStateException(message);
        }
    }
}
