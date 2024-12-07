import edu.princeton.cs.algs4.Bipartite;
import edu.princeton.cs.algs4.Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public static int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] i : times){
            adj.get(i[0]).add(new int[]{i[1],i[2]});
        }
        System.out.println(adj);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        pq.add(new int[]{k,0});
        int[] distTo = new int[n+1];
        Arrays.fill(distTo,Integer.MAX_VALUE);
        distTo[k] = 0;
        boolean[] visited = new boolean[n+1];

        int maxTime = Integer.MIN_VALUE;

        while (!pq.isEmpty()){
            int[] polled = pq.poll();
            int v = polled[0];
            int w =polled[1];
            if (visited[v])continue;

            maxTime = Math.max(maxTime,w);
            n--;
            visited[v] = true;

            for (int[] i :adj.get(v)){
                if (!visited[i[0]] &&  distTo[v] + i[1] < distTo[i[0]]){
                    pq.removeIf(a-> a[0] == i[0]);
                    distTo[i[0]] = distTo[v]+i[1];
                    pq.add(new int[]{i[0],distTo[i[0]]});
                }
            }

        }

        return n==0?maxTime:-1;
    }



    public static void main(String[] args) {
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4, k = 2;
        System.out.println(networkDelayTime(times,n,k));
    }
}
