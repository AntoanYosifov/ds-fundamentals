package implementations;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDequeTest {

    @Test
    public void testArrayDeque() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        Integer integerObject = 13;
        deque.push(13);
        deque.push(14);
        deque.remove(integerObject);

//        deque.insert(0, 14);
        System.out.println("---------");
//        Integer result = deque.get(integerObject);
//        System.out.println("Result from getByObject: " + result);
        System.out.println("---------");

        for (Integer integer: deque) {
            System.out.println(integer);
        }
        System.out.println("---------");

        System.out.println(deque.size());
    }
}