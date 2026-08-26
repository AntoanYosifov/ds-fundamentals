package tree.implementations;

import tree.interfaces.AbstractTreeAdvanced;

import java.util.List;

public class TreeAdvanced<E> implements AbstractTreeAdvanced<E> {
    @Override
    public void setParent(TreeAdvanced<E> parent) {

    }

    @Override
    public void addChild(TreeAdvanced<E> child) {

    }

    @Override
    public TreeAdvanced<E> getParent() {
        return null;
    }

    @Override
    public E getKey() {
        return null;
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
