import implementations.DoublyLinkedList;
import implementations.Queue;
import implementations.Stack;
import implementations.Tree;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Tree<Integer> integerTree = new Tree<>(7,
                new Tree<>(19,
                        new Tree<>(1),
                        new Tree<>(12),
                        new Tree<>(31)),
                new Tree<>(21),
                new Tree<>(14,
                        new Tree<>(23),
                        new Tree<>(6))
        );

        Tree<Integer> treeToAdd = new Tree<>(-1, new Tree<>(-2), new Tree<>(-3));

        integerTree.addChild(1, treeToAdd);

    }
}
