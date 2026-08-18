package implementations;

import interfaces.AbstractTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Tree<E> implements AbstractTree<E> {

    private E value;
    private Tree<E> parent;
    private List<Tree<E>> children;

    public Tree(E value, Tree<E>... subtrees) {
        this.value = value;
        this.parent = null;
        this.children = new ArrayList<>();

        this.children.addAll(Arrays.asList(subtrees));
    }

    @Override
    public List<E> orderBfs() {
        List<E> result = new ArrayList<>();
        Deque<Tree<E>> childrenQueue = new ArrayDeque<>();

        childrenQueue.offer(this);

        while (!childrenQueue.isEmpty()) {
            Tree<E> current = childrenQueue.poll();

            result.add(current.value);

            for (Tree<E> child : current.children) {
                childrenQueue.offer(child);
            }
        }

        return result;
    }

    @Override
    public List<E> orderDfs() {
        List<E> result = new ArrayList<>();

        this.doDfs(this, result);
        return result;
    }

    @Override
    public void addChild(E parentKey, Tree<E> child) {
        Tree<E> search = this.findRecursive(this, parentKey);

        if (search == null) {
            throw new IllegalArgumentException();
        }

        search.children.add(child);
        child.parent = search;
    }

    @Override
    public void removeNode(E nodeKey) {

    }

    @Override
    public void swap(E firstKey, E secondKey) {

    }

    private void doDfs(Tree<E> node, List<E> result) {
        for (Tree<E> child : node.children) {
            this.doDfs(child, result);
        }
        result.add(node.value);
    }

    private Tree<E> findRecursive(Tree<E> current, E parentKey) {
        if (current.value.equals(parentKey)) {
            return current;
        }
        for (Tree<E> child : current.children) {
            Tree<E> found = this.findRecursive(child, parentKey);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    private Tree<E> findBfs(E nodeKey) {
        Deque<Tree<E>> childrenQueue = new ArrayDeque<>();

        childrenQueue.offer(this);

        while (!childrenQueue.isEmpty()) {
            Tree<E> current = childrenQueue.poll();

            if (current.value.equals(nodeKey)) {
                return current;
            }

            for (Tree<E> child : current.children) {
                if (child.value.equals(nodeKey)) {
                    return child;
                } else {
                    childrenQueue.offer(child);
                }
            }
        }

        return null;
    }
}



