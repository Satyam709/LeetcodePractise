import java.util.*;

public class MinDiameterOnTwoTreeMerge {
    public static int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {

        int d1 = minDiameter(edges1);
        int t1 = Math.max(d1/2,(d1+1)/2);

        int d2 = minDiameter(edges2);
        int t2 = Math.max(d2/2,(d2+1)/2);

        return Math.max((t1+t2+1),Math.max(d1,d2));
    }

    private static int minDiameter(int[][] edges) {
        if (edges.length <2 )return edges.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int max = -1;

        for (int[] i : edges)
            max = Math.max(max, Math.max(i[0], i[1]));

        int[] nodes = new int[max + 1];

        for (int[] i : edges) {
            int u = i[0], v = i[1];
            nodes[u]++;
            nodes[v]++;
        }

        for (int i = 0; i <= max; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] i : edges) {
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }

        return bfs(adj, nodes);
    }

    private static int bfs(ArrayList<ArrayList<Integer>> adj, int[] nodes) {
        HashSet<Integer> leaf = new HashSet<>();
        HashSet<Integer> nonLeaf = new HashSet<>();
        // add leaf nodes to queue
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] != 1) {
                nonLeaf.add(i);
                continue;
            }
            leaf.add(i);
            nodes[i] -= 2;
        }
        int dia = 0;

        for (int i : leaf) {

            System.out.println("\nfor non leaf "+i);
            int d = dfs(adj, i, 0,new HashSet<>());
            dia = Math.max(dia, d);

        }
        System.out.println("got dia = "+dia);
        return dia;
    }

    private static int dfs(ArrayList<ArrayList<Integer>> adj, int source, int lvl,HashSet<Integer> visited) {

        if (visited.contains(source))return lvl;

        System.out.println("i m on "+ source+" with current lvl "+lvl);
        int max = lvl;

        visited.add(source);

        for (int n : adj.get(source)) {
            if (!visited.contains(n)) {
                System.out.println("visiting "+ n);
                max = Math.max(max, dfs(adj, n, lvl + 1, visited));
            }
        }
        System.out.println("max ->"+max);
        return max;
    }

    public static void main(String[] args) {
        int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {2, 4}, {2, 5}, {3, 6}, {2, 7}},
                edges2 = {{0, 1}, {0, 2}, {0, 3}, {2, 4}, {2, 5}, {3, 6}, {2, 7}};

        int[][] edges11 = {{0,1},{0,2},{0,3}}, edges22 = {{0,1}};

        int[][] edges111 = {{1,0},{2,3},{1,4},{2,1},{2,5}}
        ,edges222 =
                {{4,5},{2,6},{3,2},{4,7},{3,4},{0,3},{1,0},{1,8}};

        int[][] e1 =
                {{0,1},{2,0},{3,2},{3,6},{8,7},{4,8},{5,4},{3,5},{3,9}},
        e2 =
                {{0,1},{0,2},{0,3}};

        System.out.println("\n answer = "+minimumDiameterAfterMerge(e1,e2));
    }
}
