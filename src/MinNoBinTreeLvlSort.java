import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class MinNoBinTreeLvlSort {

    public static class TreeNode {
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

    public static int minimumOperations(TreeNode root) {
        ArrayList<PriorityQueue<Integer>> li = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> li2 = new ArrayList<>();
        traverse(root, li, 0, map, li2);
        // System.out.println(li);
        // System.out.println(map);
        // System.out.println(li2);

        int swap = 0;

        for (int i = 1; i < li.size(); i++) {
            PriorityQueue<Integer> pq = li.get(i);

            int crnt = 0;

            while (!pq.isEmpty()) {
                int top = pq.poll();
                int idx = map.get(top);
                if (idx != crnt) {
                    swap++;

                    ArrayList<Integer> lii = li2.get(i);
                    int swapper = lii.get(crnt);
                    lii.set(idx, swapper);
                    map.put(swapper, idx);
                }

                crnt++;
            }

        }

        return swap;
    }

    private static void traverse(TreeNode root, ArrayList<PriorityQueue<Integer>> li, int lvl, HashMap<Integer, Integer> map, ArrayList<ArrayList<Integer>> li2) {
        if (root == null) return;
        if (li.size() <= lvl) {
            // System.out.println("creating li"+lvl);
            li.add(new PriorityQueue<Integer>());
            li2.add(new ArrayList<>());
        }
        PriorityQueue<Integer> pq = li.get(lvl);
        pq.add(root.val);
        map.put(root.val, pq.size() - 1);
        li2.get(lvl).add(root.val);

        traverse(root.left, li, lvl + 1, map, li2);
        traverse(root.right, li, lvl + 1, map, li2);
    }


    public static void main(String[] args) {
    }

}
