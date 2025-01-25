import java.util.*;

public class Daily_24_01_25 {
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> li = new LinkedList<>();
        int v = graph.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }
        int[] outDeg = new int[v];
        for (int i = 0; i < v; i++) {
            outDeg[i] = graph[i].length;

            for (int j : graph[i]) {
                adj.get(j).add(i);
            }
        }

        boolean[] visited = new boolean[v];

        Queue<Integer> revTopoOrder = new LinkedList<>();

        for (int i = 0; i < v; i++) {
            if (!visited[i])
                dfs(graph, i, visited, revTopoOrder);
        }

        boolean[] explored = new boolean[v];
        while (!revTopoOrder.isEmpty()) {
            int t = revTopoOrder.poll();
            explored[t] = true;
            if (outDeg[t]!=0)continue;
            for (int i : adj.get(t)) {
                if (explored[i]) break;
                outDeg[i]--;
            }

        }

        for (int i = 0; i < v; i++) {
            if (outDeg[i] == 0) li.add(i);
        }

        return li;
    }

    private static void dfs(int[][] graph, int v, boolean[] visited, Queue<Integer> stk) {
        if (visited[v]) return;
        visited[v] = true;
        for (int i : graph[v]) {
            dfs(graph, i, visited, stk);
        }
        stk.add(v);
    }


    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(eventualSafeNodes(graph));
    }
}
