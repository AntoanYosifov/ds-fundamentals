package implementations;

import interfaces.Deque;

import java.util.Iterator;

public class ArrayDeque<E> implements Deque<E> {

    private final int INITIAL_CAPACITY = 3;

    private int size;

    private int head;
    private int tail;

    private Object[] elements;

    public ArrayDeque() {
        this.elements = new Object[INITIAL_CAPACITY];
        this.size = 0;
        int middle = INITIAL_CAPACITY / 2;
        this.head = this.tail = middle;
    }

    @Override
    public void add(E element) {
        this.addLast(element);
    }

    @Override
    public void offer(E element) {
        this.addLast(element);
    }

    @Override
    public void addFirst(E element) {
        if (isEmpty()) {
            this.addLast(element);
        } else {
            if (this.head == 0) {
                this.elements = grow();
            }
            this.elements[--this.head] = element;
            this.size++;
        }
    }

    @Override
    public void addLast(E element) {
        if (isEmpty()) {
            this.elements[this.tail] = element;
        } else {
            if (this.tail == this.elements.length - 1) {
                this.elements = grow();
            }
            this.elements[++tail] = element;
        }

        this.size++;
    }

    @Override
    public void push(E element) {
        this.addFirst(element);
    }

    @Override
    public void insert(int index, E element) {

    }

    @Override
    public void set(int index, E element) {

    }

    @Override
    public E peek() {
        if (!isEmpty()) {
            return getAt(this.head);
        }
        return null;
    }

    @Override
    public E poll() {
        return removeFirst();
    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E get(Object object) {
        return null;
    }

    @Override
    public E remove(int index) {
        int realIndex = this.head + index;
        ensureValidIndex(realIndex);

        E element = this.getAt(realIndex);
        this.elements[realIndex] = null;

        if (realIndex == this.head || realIndex == this.tail) {
            if (realIndex == this.head) {
                this.head++;
            } else {
                this.tail--;
            }
        } else {
            int leftElements = realIndex - this.head;
            int rightElements = this.tail - realIndex;

            if (leftElements > rightElements) {
                shiftLeft(realIndex);
            } else {
                shiftRight(realIndex);
            }
        }

        this.size--;
        if(isEmpty()) {
            resetPointers();
        }
        return element;
    }


    @Override
    public E remove(Object object) {
        return null;
    }

    @Override
    public E removeFirst() {
        if (!isEmpty()) {
            E element = this.getAt(this.head);

            this.elements[this.head] = null;
            this.head++;
            this.size--;
            if (isEmpty()) {
                resetPointers();
            }
            return element;
        }
        return null;
    }

    @Override
    public E removeLast() {
        if (!isEmpty()) {
            E element = this.getAt(this.tail);

            this.elements[this.tail] = null;
            this.tail--;
            this.size--;
            if (isEmpty()) {
               resetPointers();
            }
            return element;
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return this.elements.length;
    }

    @Override
    public void trimToSize() {

    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    private Object[] grow() {
        int newCapacity = this.elements.length * 2 + 1;
        Object[] newElements = new Object[newCapacity];

        int middle = newCapacity / 2;

        int begin = middle - this.size / 2;

        int index = this.head;

        for (int i = begin; index <= this.tail; i++) {
            newElements[i] = this.elements[index++];
        }

        this.head = begin;
        this.tail = this.head + this.size - 1;

        return newElements;
    }

    @SuppressWarnings("unchecked")
    private E getAt(int index) {
        return (E) this.elements[index];
    }

    private void ensureValidIndex(int realIndex) {
        if (realIndex < this.head || realIndex > this.tail) {
            throw new IndexOutOfBoundsException("Index out of bounds for index: " + (realIndex - this.head));
        }
    }

    private void shiftRight(int realIndex) {
        for (int i = realIndex; i > head; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[head] = null;
        this.head++;
    }

    private void shiftLeft(int realIndex) {
        for (int i = realIndex; i < tail; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[tail] = null;
        this.tail--;
    }

    private void resetPointers() {
        int middle = this.elements.length / 2;
        this.head = this.tail = middle;
    }

}
