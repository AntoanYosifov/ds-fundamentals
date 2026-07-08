import implementations.ArrayList;
import implementations.SinglyLinkedList;
import implementations.Stack;

public class Main {
    public static void main(String[] args) {

        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        list.addFirst("1");
        list.addFirst("2");
        list.addLast("3");
        System.out.println();
        list.removeFirst();
        System.out.println();
    }
}
