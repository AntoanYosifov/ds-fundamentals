package tree.implementations;


import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class TreeFactory {
    private Map<Integer, TreeAdvanced<Integer>> nodesByKeys;

    public TreeFactory() {
        this.nodesByKeys = new LinkedHashMap<>();
    }

    public TreeAdvanced<Integer> createTreeFromStrings(String[] input) {
        for (String params : input) {
            int[] keys = Arrays.stream(params.split("\\s+")).mapToInt(Integer::parseInt)
                    .toArray();

            int parentKey = keys[0];
            int childKey = keys[1];

            this.addEdge(parentKey, childKey);
        }
        return this.getRoot();
    }

    private TreeAdvanced<Integer> getRoot() {

        for (TreeAdvanced<Integer> value : nodesByKeys.values()) {
            if(value.getParent() == null) {
                return value;
            }
        }
        return null;
    }

    public TreeAdvanced<Integer> createNodeByKey(int key) {
        this.nodesByKeys.putIfAbsent(key, new TreeAdvanced<>(key));
        return this.nodesByKeys.get(key);
    }

    public void addEdge(int parent, int child) {
        TreeAdvanced<Integer> parentByKey = this.createNodeByKey(parent);
        TreeAdvanced<Integer> childByKey = this.createNodeByKey(child);

        childByKey.setParent(parentByKey);
        parentByKey.addChild(childByKey);
    }
}



