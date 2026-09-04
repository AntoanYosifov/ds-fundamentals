package tree.implementations;

import tree.interfaces.AbstractTreeAdvanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeAdvanced<E> implements AbstractTreeAdvanced<E> {

    private E key;
    private TreeAdvanced<E> parent;
    private List<TreeAdvanced<E>> children;

    public TreeAdvanced(E key, TreeAdvanced<E>... children) {
        this.key = key;
        this.children = new ArrayList<>();
        this.children.addAll(Arrays.asList(children));
        for (TreeAdvanced<E> child : children) {
            child.setParent(this);
        }
    }

    @Override
    public void setParent(TreeAdvanced<E> parent) {
        this.parent = parent;
    }

    @Override
    public void addChild(TreeAdvanced<E> child) {
        this.children.add(child);
    }

    @Override
    public TreeAdvanced<E> getParent() {
        return this.parent;
    }

    @Override
    public E getKey() {
        return this.key;
    }

    @Override
    public String getAsString() {
        return null;
    }

    @Override
    public List<E> getLeafKeys() {
        return null;
    }

    @Override
    public List<E> getMiddleKeys() {
        return null;
    }

    @Override
    public TreeAdvanced<E> getDeepestLeftmostNode() {
        return null;
    }

    @Override
    public List<E> getLongestPath() {
        return null;
    }

    @Override
    public List<List<E>> pathsWithGivenSum(int sum) {
        return null;
    }

    @Override
    public List<TreeAdvanced<E>> subTreesWithGivenSum(int sum) {
        return null;
    }

}
