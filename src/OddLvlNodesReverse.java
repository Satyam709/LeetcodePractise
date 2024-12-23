import java.util.ArrayList;
import java.util.Stack;

public class OddLvlNodesReverse {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        ArrayList<Stack<Integer>> nodes = getStack(root);
        System.out.println(nodes);
        putNodes(root, nodes, 0);
        return root;
    }

    private ArrayList<Stack<Integer>> getStack(TreeNode root) {
        int depth = getMaxDepth(root);
        System.out.println("depth = " + depth);
        ArrayList<Stack<Integer>> nodes = new ArrayList<>(depth);
        for (int i = 0; i < depth; i++) {
            nodes.add(i, new Stack<>());
        }
        getNodes(root, nodes, 0);
        return nodes;
    }

    private int getMaxDepth(TreeNode root) {
        int lvl = 0;
        while (root != null) {
            root = root.left;
            lvl++;
        }
        return lvl;
    }


    private void getNodes(TreeNode root, ArrayList<Stack<Integer>> li, int lvl) {
        if (root == null) return;

        li.get(lvl).push(root.val);

        getNodes(root.left, li, lvl + 1);
        getNodes(root.right, li, lvl + 1);

    }

    private void putNodes(TreeNode root, ArrayList<Stack<Integer>> li, int lvl) {
        if (root == null) return;
        if (lvl % 2 != 0) {
            root.val = li.get(lvl).pop();
        }
        putNodes(root.left, li, lvl + 1);
        putNodes(root.right, li, lvl + 1);
    }
}
