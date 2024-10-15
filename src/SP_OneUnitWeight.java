import java.util.*;

public class SP_OneUnitWeight {
    public int[] shortestPath(int[][] edges, int N, int m, int src) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        int[] sp = new int[N];
        Arrays.fill(sp, -1);
        sp[src] = 0;
        boolean[] visited = new boolean[N];
        visited[src] =true;

        for (int[] e : edges) {
            addEdge(graph, e[0], e[1]);
        }

        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{src, 0});

        while (!q.isEmpty()) {
            Integer[] t = q.poll();
            List<Integer> li = graph.get(t[0]);
            sp[t[0]] = t[1];

            if (li == null) break;
            for (int i : li) {
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(new Integer[]{i, sp[t[0]] + 1});
                }
            }
//            for (Integer[] i :q){
//                System.out.print(Arrays.toString(i)+" ,");
//            }
//            System.out.println();
        }

//        System.out.println(graph);

        return sp;
    }

    private void addEdge(HashMap<Integer, List<Integer>> graph, int u, int v) {
        graph.compute(u, ((integer, edges1) -> {
            if (edges1 == null) {
                edges1 = new ArrayList<>();
            }
            edges1.add(v);
            return edges1;
        }));

        graph.compute(v, ((integer, edges1) -> {
            if (edges1 == null) {
                edges1 = new ArrayList<>();
            }
            edges1.add(u);
            return edges1;
        }));

    }

    public static void main(String[] args) {
        int n = 9, m = 10;
        int[][] edges = {{0, 1}, {0, 3}, {3, 4}, {4, 5}, {5, 6}, {1, 2}, {2, 6}, {6, 7}, {7, 8}, {6, 8}};
        int src = 0;
        SP_OneUnitWeight obj = new SP_OneUnitWeight();
        System.out.println(Arrays.toString(obj.shortestPath(edges, n, m, src)));
    }
}
