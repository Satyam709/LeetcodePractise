import java.util.*;

public class SpInDAG {

    private static class Edge {
        public final int from, to, weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + " -> " + to + " = " + weight;
        }
    }

    private static void toposort(HashMap<Integer, List<Edge>> graph, int v, boolean[] visited, Stack<Integer> stk) {
        if (visited[v]) return;
        visited[v] = true;
        List<Edge> li = graph.get(v);
        if (li != null)
            for (Edge i : li) {
                if (i != null && !visited[i.to]) {
                    toposort(graph, i.to, visited, stk);
                }
            }
        stk.push(v);
    }


    public static int[] shortestPath(int N, int M, int[][] edges) {
        //Code here
        HashMap<Integer, List<Edge>> graph = new HashMap<>();
        int[] edgeTo = new int[N];

        int[] sp = new int[N];
        Arrays.fill(sp, Integer.MAX_VALUE);
        sp[0] = 0;
        boolean[] visited = new boolean[N];

        for (int[] e : edges) {
            graph.compute(e[0], ((integer, edges1) -> {
                if (edges1 == null) {
                    edges1 = new ArrayList<>();
                }
                edges1.add(new Edge(e[0], e[1], e[2]));
                return edges1;
            }));
        }
        //System.out.println(graph);
        Stack<Integer> stk = new Stack<>();
        toposort(graph, 0, visited, stk);
        //System.out.println(stk);

        while (!stk.empty()) {
            int crnt = stk.pop();
            List<Edge> li = graph.get(crnt);
            if (li != null)
                for (Edge i : li) {
                    relax(i, sp, edgeTo);
                }
        }
        //System.out.println(Arrays.toString(edgeTo));
        //System.out.println(Arrays.toString(sp));
        for (int i = 0; i < sp.length; i++) {
            if (sp[i] == Integer.MAX_VALUE)
                sp[i] = -1;
        }
        return sp;
    }

    private static void relax(Edge e, int[] sp, int[] edgeTo) {
        int from = e.from;
        int to = e.to;

        if (e.weight + sp[from] < sp[to]) {
            sp[to] = e.weight + sp[from];
            edgeTo[to] = from;
        }
    }

    public static void main(String[] args) {
//        int n = 6, m = 7;
//        int[][] edge = {{0, 1, 2}, {0, 4, 1}, {4, 5, 4}, {4, 2, 2}, {1, 2, 3}, {2, 3, 6}, {5, 3, 1}};

        int n = 4, m = 2;
        int[][] edge = {{0, 1, 2}, {0, 2, 1}};

        System.out.println(Arrays.toString(shortestPath(n, m, edge)));
    }
}
