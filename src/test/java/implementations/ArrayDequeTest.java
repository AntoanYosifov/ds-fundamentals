package implementations;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void testArrayDeque() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.push(13);
        deque.push(14);
        deque.push(15);
        deque.push(16);
        System.out.println();
        deque.insert(2, 69);
        System.out.println(deque.capacity());

    }
}