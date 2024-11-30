import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KStopCheapestFlight {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Queue<int[]> q = new LinkedList<>();
        // format node,price,stops
        q.add(new int[]{0, 0, 0});

//        boolean[] visited = new boolean[];

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(i, new ArrayList<>());
        }

        for (int[] i : flights) {
            adj.get(i[0]).add(new int[]{i[1], i[2]});
        }

        int[] distTo =new int[n];
        Arrays.fill(distTo,Integer.MAX_VALUE);
        distTo[src] = 0;

        System.out.println("graph :");
        System.out.println(adj);
        int min = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] polled = q.poll();

            int node = polled[0], price = polled[1], stops = polled[2];

            for (int[] i : adj.get(node)) {
                if (stops < k  && price + i[1] < distTo[i[0]]) {
                    distTo[i[0]] = price + i[1];
                    q.add(new int[]{i[0], price + i[1], stops + 1});
                }
                if (i[0] == dst)
                    min = Math.min(min,price+i[1]);
            }

        }
        return min;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0, dst = 3, k = 1;

        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }
}
