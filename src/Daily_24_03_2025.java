import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Daily_24_03_2025 {
    private static final int MOD = 1_000_000_007;

    public static int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            int u = road[0], v = road[1], w = road[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        long[] distTo = new long[n];
        Arrays.fill(distTo, Long.MAX_VALUE);
        int[] ways = new int[n];

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        distTo[0] = 0;
        ways[0] = 1;
        //{v,dist}
        pq.add(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] top = pq.poll();
            int node = (int) top[0];
            long currDist = top[1];

            if (currDist > distTo[node]) continue;

            for (int[] neighbor : adj.get(node)) {
                int v = neighbor[0], w = neighbor[1];
                long newDist = currDist + w;

                if (newDist < distTo[v]) {
                    distTo[v] = newDist;
                    ways[v] = ways[node];
                    pq.add(new long[]{v, newDist});
                } else if (newDist == distTo[v]) {
                    ways[v] = (ways[v] + ways[node]) % MOD;
                }
            }
        }
        return ways[n - 1];
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] roads = {{0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},{3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}};

        System.out.println(countPaths(n,roads));
    }
}
