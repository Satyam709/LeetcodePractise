import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestValEachLvl {
    public static List<Integer> largestValues(OddLvlNodesReverse.TreeNode root) {
        Queue<pair> q = new LinkedList<>();
        List<Integer> li = new ArrayList<>();
        int lvl = 0;
        q.add(new pair(root, lvl));
        while (!q.isEmpty()) {
            int lvlMax = Integer.MIN_VALUE;
            while (!q.isEmpty() && q.peek().lvl == lvl) {
                pair t = q.poll();
                if (t.node == null) continue;
                lvlMax = Math.max(lvlMax, t.node.val);

                if (t.node.left != null)
                    q.add(new pair(t.node.left, lvl + 1));
                if (t.node.right != null)
                    q.add(new pair(t.node.right, lvl + 1));

            }
            li.add(lvlMax);
            lvl++;
        }
        return li;
    }

    record pair(OddLvlNodesReverse.TreeNode node, int lvl) {
    }

}
