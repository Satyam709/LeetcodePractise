import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Daily_24_02_2025 {
    public static int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        int[] disfrom = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        HashSet<Integer> leaves = new HashSet<>();
        for (int i = 1; i < n; i++) {
            if (adj.get(i).size() == 1) leaves.add(i);
        }

        System.out.println("leaves are = " + leaves);

        boolean[] visited = new boolean[n];

        fillDistances(disfrom, 0, adj, amount, visited);

        System.out.println("Distances are :");
        System.out.println(Arrays.toString(disfrom));

        return 0;
    }

    private static int fillDistances(int[] disFrom, int v, List<List<Integer>> adj, int[] amount, boolean[] visited) {
        List<Integer> children = adj.get(v);
        if (visited[v]) return 0;

        visited[v] = true;
        disFrom[v] = amount[v];

        for (int u : children) {
            disFrom[v] += fillDistances(disFrom, u, adj, amount, visited);
        }
        return disFrom[v];
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {3, 4}};
        int bob = 3;
        int[] amount = {-2, 4, 2, -4, 6};
        System.out.println("out = " + mostProfitablePath(edges, bob, amount));
    }
}
