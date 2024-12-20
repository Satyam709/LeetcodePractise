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
        ArrayList<Stack<Integer>> nodes = new ArrayList<>();
        getNodes(root, nodes, 0);
        return nodes;
    }

    private void getNodes(TreeNode root, ArrayList<Stack<Integer>> li, int lvl) {
        if (root == null) return;
        Stack<Integer> stk;
        if (lvl >= li.size()) {
            stk = new Stack<>();
            li.add(lvl, stk);
        }else stk = li.get(lvl);

        System.out.println("adding at lvl "+lvl+ " : "+root.val);

        stk.push(root.val);

        getNodes(root.left, li, lvl + 1);
        getNodes(root.right, li, lvl + 1);

    }

    private void putNodes(TreeNode root, ArrayList<Stack<Integer>> li, int lvl) {
        if (root == null) return;
        if (lvl % 2 != 0) {
            System.out.println("replacing at lvl "+lvl+ " : "+root.val+" -> "+li.get(lvl).peek());
            root.val = li.get(lvl).pop();
        }
        putNodes(root.left, li, lvl + 1);
        putNodes(root.right, li, lvl + 1);
    }
}
