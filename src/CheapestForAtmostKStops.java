import edu.princeton.cs.algs4.In;

import java.util.*;

public class CheapestForAtmostKStops {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        k++;
        HashMap<Integer, List<Integer[]>> graph = new HashMap<>();
        for (int[] i : flights) {
            graph.compute(i[0], (key, val) -> {
                if (val == null)
                    val = new ArrayList<>();
                val.add(new Integer[]{i[1], i[2]});
                return val;
            });
        }
        return limited_dfs(k, n, src, dst, graph);
    }

    private static int limited_dfs(int k, int n, int src, int dest, HashMap<Integer, List<Integer[]>> graph) {
        boolean[] visited = new boolean[n];
        int[] sp = new int[n];
        Arrays.fill(sp, Integer.MAX_VALUE);
        sp[src] = 0;
        dfs(k, dest, src, -1, 0, graph, visited, sp);
        //System.out.println(Arrays.toString(sp));
        return sp[dest] == Integer.MAX_VALUE ? -1 : sp[dest];
    }

    private static void dfs(int k, int dst, int v, int frm, int stops, HashMap<Integer, List<Integer[]>> graph, boolean[] visited, int[] sp) {
        if (stops > k) return;
        if (visited[v]) return;

        visited[v] = true;
        List<Integer[]> li = graph.get(v);
        if (frm > 0)
            if (v == dst)
                sp[v] = Math.min(sp[v], frm);
            else sp[v] = frm;

        if (li != null) {
            for (Integer[] i : li) {
                if (!visited[i[0]]) {
                    dfs(k, dst, i[0], sp[v] + i[1], stops + 1, graph, visited, sp);
                }
            }
        }
        visited[v] = false;
        //sp[v] = Integer.MAX_VALUE;
    }

    public static int findCheapestPrice2(int n, int[][] flights, int src, int dst, int limit) {
        int[] edgeTo = new int[n];
        int[] dist = new int[n];

        // make graph
        ArrayList<LinkedList<Integer[]>> graph = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            edgeTo[i] = -1;
            dist[i] = Integer.MAX_VALUE;
            graph.add(i,new LinkedList<>());
        }

        // add edges
        for(int[] i : flights){
            graph.get(i[0]).add(new Integer[]{i[1],i[2]});
        }

//        for (int i =0 ;i<n;i++) {
//            LinkedList<Integer[]> li = graph.get(i);
//            System.out.print(i+" ->");
//            for (Integer[] j : li)
//                System.out.print(Arrays.toString(j) + ',');
//            System.out.println();
//        }

        Queue<Integer> q = new LinkedList<>();
        int k = 0;
        dist[src] = 0;
        edgeTo[src]=src;
        q.add(src);

        while (!q.isEmpty() && k <= limit){
            k++;
            int v = q.poll();

            // visit neighbours
            for (Integer[] li :graph.get(v)){
                int u = li[0], w = li[1];
                if (dist[v] + w < dist[u]){
                    edgeTo[u] = v;
                    dist[u] = dist[v]+w;
                }
                q.add(u);
            }
        }

        int i = dst;
        List<Integer> path = new LinkedList<>();
        while (edgeTo[i]!=i && edgeTo[i]!=-1){
            path.addFirst(i);
            i = edgeTo[i];
        }
        System.out.println(path);
        return dist[dst];
    }

    public static void main(String[] args) {
        int n = 17;
        int src = 13, dst = 4, k = 13;

        int[][] flights =
                {{0, 12, 28}, {5, 6, 39}, {8, 6, 59}, {13, 15, 7}, {13, 12, 38}, {10, 12, 35}, {15, 3, 23}, {7, 11, 26}, {9, 4, 65}, {10, 2, 38}, {4, 7, 7}, {14, 15, 31}, {2, 12, 44}, {8, 10, 34}, {13, 6, 29}, {5, 14, 89}, {11, 16, 13}, {7, 3, 46}, {10, 15, 19}, {12, 4, 58}, {13, 16, 11}, {16, 4, 76}, {2, 0, 12}, {15, 0, 22}, {16, 12, 13}, {7, 1, 29}, {7, 14, 100}, {16, 1, 14}, {9, 6, 74}, {11, 1, 73}, {2, 11, 60}, {10, 11, 85}, {2, 5, 49}, {3, 4, 17}, {4, 9, 77}, {16, 3, 47}, {15, 6, 78}, {14, 1, 90}, {10, 5, 95}, {1, 11, 30}, {11, 0, 37}, {10, 4, 86}, {0, 8, 57}, {6, 14, 68}, {16, 8, 3}, {13, 0, 65}, {2, 13, 6}, {5, 13, 5}, {8, 11, 31}, {6, 10, 20}, {6, 2, 33}, {9, 1, 3}, {14, 9, 58}, {12, 3, 19}, {11, 2, 74}, {12, 14, 48}, {16, 11, 100}, {3, 12, 38}, {12, 13, 77}, {10, 9, 99}, {15, 13, 98}, {15, 12, 71}, {1, 4, 28}, {7, 0, 83}, {3, 5, 100}, {8, 9, 14}, {15, 11, 57}, {3, 6, 65}, {1, 3, 45}, {14, 7, 74}, {2, 10, 39}, {4, 8, 73}, {13, 5, 77}, {10, 0, 43}, {12, 9, 92}, {8, 2, 26}, {1, 7, 7}, {9, 12, 10}, {13, 11, 64}, {8, 13, 80}, {6, 12, 74}, {9, 7, 35}, {0, 15, 48}, {3, 7, 87}, {16, 9, 42}, {5, 16, 64}, {4, 5, 65}, {15, 14, 70}, {12, 0, 13}, {16, 14, 52}, {3, 10, 80}, {14, 11, 85}, {15, 2, 77}, {4, 11, 19}, {2, 7, 49}, {10, 7, 78}, {14, 6, 84}, {13, 7, 50}, {11, 6, 75}, {5, 10, 46}, {13, 8, 43}, {9, 10, 49}, {7, 12, 64}, {0, 10, 76}, {5, 9, 77}, {8, 3, 28}, {11, 9, 28}, {12, 16, 87}, {12, 6, 24}, {9, 15, 94}, {5, 7, 77}, {4, 10, 18}, {7, 2, 11}, {9, 5, 41}};

//        int n = 4;
//        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
//        int src = 0, dst = 3, k = 1;
        System.out.println(findCheapestPrice2(n, flights, src, dst, k));
    }
}
