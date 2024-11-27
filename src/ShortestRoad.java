import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestRoad {
    public static int[] shortestDistanceAfterQueries(int n, int[][] queries) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int[] out = new int[queries.length];

        int[] distTo = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(i, new ArrayList<>());
            if (i < n - 1) {
                adj.get(i).add(i + 1);
            }
            distTo[i] = i;
        }

        System.out.println("original :");
        System.out.println(Arrays.toString(distTo));
        System.out.println(adj);
        System.out.println("traversing edges queries :");

        int t = 0;
        for (int[] i : queries) {
            adj.get(i[0]).add(i[1]);
            System.out.println("updated graph : " + adj);
            bfs(distTo, i[0], adj);
            out[t++] = distTo[n - 1];
            System.out.println("distTo = " + Arrays.toString(distTo));
        }
        return out;
    }

    private static void bfs(int[] distTo, int source, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[distTo.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = true;

        while (!q.isEmpty()) {
            int v = q.poll();

            for (int i : adj.get(v)) {
                if (visited[i]) continue;
                int finalDist = distTo[v] + 1;
                if (finalDist < distTo[i])
                    distTo[i] = finalDist;
                visited[i] = true;
                q.add(i);
            }
        }
    }

    public static void main(String[] args) {
//        int[][] queries = {{2,4},{0,2},{0,4}};
        int[][] queries = {{1, 4}, {2, 4}};
        int n = 6;
        System.out.println(Arrays.toString(shortestDistanceAfterQueries(n, queries)));
    }
}
