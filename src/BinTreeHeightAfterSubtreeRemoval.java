import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BinTreeHeightAfterSubtreeRemoval {
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

    public static int[] treeQueries(TreeNode root, int[] queries) {
        int[][] hx = new int[100001][4];
        initialise_height(root, 1, 0, hx);
        System.out.println(Arrays.deepToString(hx));
        Set<Integer> set = new HashSet<>();
        mark_longest(root, hx, set);
        System.out.println(set);
        for (int i = 0; i < queries.length; i++) {
            int tmp =queries[i];
            queries[i] = hx[1][0];
            if (set.contains(tmp)) {
                int p = hx[tmp][1];
//                queries[i] -=hx[] hx[p][3];
            }
        }

        return null;
    }

    private static void initialise_height(TreeNode root, int from, int dir, int[][] hx) {
        if (root == null) return;
        int l = 0, r = 0;
        if (root.left != null) {
            if (root.val == 1) dir = -1;
            initialise_height(root.left, root.val, dir, hx);
            l = hx[root.left.val][0] + 1;
        }
        if (root.right != null) {
            if (root.val == 1) dir = -2;
            initialise_height(root.right, root.val, dir, hx);
            r = hx[root.right.val][0] + 1;
        }
        if (r > l) {
            hx[root.val][0] = r;
            hx[root.val][3] = l;
        } else {
            hx[root.val][0] = l;
            hx[root.val][3] = r;
        }
        hx[root.val][1] = from;
        hx[root.val][2] = dir;
    }

    private static void mark_longest(TreeNode root, int[][] hx, Set<Integer> set) {
        while (root != null) {
            set.add(root.val);
            int l = root.left == null ? 0 : hx[root.left.val][0], r = root.right == null ? 0 : hx[root.right.val][0];

            if (l > r) {
                root = root.left;
            } else {
                root = root.right;
            }

        }
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
