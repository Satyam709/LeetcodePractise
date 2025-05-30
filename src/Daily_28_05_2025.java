import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Daily_28_05_2025 {
    public static int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        ArrayList<ArrayList<Integer>> graph1 = new ArrayList<>();
        for (int i = 0; i <= edges1.length; i++) {
            graph1.add(new ArrayList<>());
        }
        for (int[] e : edges1) {
            graph1.get(e[0]).add(e[1]);
            graph1.get(e[1]).add(e[0]);
        }

        ArrayList<ArrayList<Integer>> graph2 = new ArrayList<>();
        for (int i = 0; i <= edges2.length; i++) {
            graph2.add(new ArrayList<>());
        }
        for (int[] e : edges2) {
            graph2.get(e[0]).add(e[1]);
            graph2.get(e[1]).add(e[0]);
        }

        int[] tc1 = getTargetsCount(graph1, k);
        int[] tc2 = getTargetsCount(graph2, k - 1);
        final int tc2Max = Arrays.stream(tc2).max().orElse(0);
        return Arrays.stream(tc1).map(it -> it + tc2Max).toArray();
    }

    private static int[] getTargetsCount(ArrayList<ArrayList<Integer>> graph, int k) {
        int[] tc = new int[graph.size()];
        Arrays.fill(tc,1);

        for (int i = 0; i <graph.size(); i++) {
            Queue<Integer[]> q = new LinkedList<>();
            q.add(new Integer[]{i, 0});
            boolean[] visited = new boolean[graph.size()];
            visited[i] = true;


            while (!q.isEmpty()) {
                Integer[] top = q.poll();
                if (top[1] > k) continue;
                if (top[1] == k) continue;

                for (int n : graph.get(top[0])) {
                    if (!visited[n]) {
                        q.add(new Integer[]{n, top[1] + 1});
                        visited[n] = true;
                        tc[i]++;
                    }
                }
            }

        }
        System.out.println("tc = "+ Arrays.toString(tc));
        return tc;
    }

    public static void main(String[] args) {
        int[][] edges1 = {{0,1},{0,2},{2,3},{2,4}};
        int[][] edges2 = {{0,1},{0,2},{0,3},{2,7},{1,4},{4,5},{4,6}};
        int k = 2;

        System.out.println(Arrays.toString(maxTargetNodes(edges1,edges2,k)));
    }
}
