package tree.interfaces;


import tree.implementations.TreeAdvanced;

import java.util.List;

public interface AbstractTreeAdvanced<E> {
    void setParent(TreeAdvanced<E> parent);

    void addChild(TreeAdvanced<E> child);

    TreeAdvanced<E> getParent();

    E getKey();

    String getAsString();

    List<E> getLeafKeys();

    List<E> getMiddleKeys();

    TreeAdvanced<E> getDeepestLeftmostNode();

    List<E> getLongestPath();

    List<List<E>> pathsWithGivenSum(int sum);

    List<TreeAdvanced<E>> subTreesWithGivenSum(int sum);
}
