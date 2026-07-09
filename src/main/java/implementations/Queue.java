package implementations;

import interfaces.AbstractQueue;

import java.util.Iterator;

public class Queue<E> implements AbstractQueue<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        private E value;
        private Node<E> next;
        Node(E element) {
            this.value = element;
        }
    }

    public Queue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void offer(E element) {
        Node<E> toOffer = new Node<>(element);

        if(this.head == null) {
            this.head = toOffer;
            this.tail = toOffer;
        } else {
            this.tail.next = toOffer;
            this.tail = toOffer;
        }
        this.size++;
    }

    @Override
    public E poll() {
        ensureNonEmpty();
        Node<E> toPoll = this.head;

        this.head = this.head.next;
        if(size == 1) {
            this.tail = null;
        }
        this.size--;
        return toPoll.value;
    }

    @Override
    public E peek() {
        ensureNonEmpty();
        return this.head.value;
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
        return new Iterator<>() {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return this.current != null;
            }

            @Override
            public E next() {
                E value = this.current.value;

                this.current = this.current.next;

                return value;
            }
        };
    }

    private void ensureNonEmpty() {
        if(this.isEmpty()) {
            throw new IllegalStateException();
        }
    }
}
