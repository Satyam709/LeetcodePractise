import java.util.*;

public class DijkastrasTypical {

    private static class SVertex implements Comparable<SVertex> {
        int v;
        int w;

        SVertex(int v ,int w){
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(SVertex o) {
            return Integer.compare(this.v,o.v);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SVertex sVertex = (SVertex) o;
            return v == sVertex.v && w == sVertex.w;
        }

        @Override
        public int hashCode() {
            return Objects.hash(v, w);
        }
    }

    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        // Write your code here
        int[] sp = new int[V];
        Arrays.fill(sp, Integer.MAX_VALUE);
        sp[S] = 0;
        PriorityQueue<SVertex> pq = new PriorityQueue<>(V * V);
        pq.add(new SVertex(S,0));
        while (!pq.isEmpty()) {
            SVertex tmp = pq.poll();
            int v = tmp.v;
            for (ArrayList<Integer> i : adj.get(v)) {
                relax(sp, i, pq, v);
            }
        }
        for (int i = 0; i < sp.length; i++) {
            if (sp[i] == Integer.MAX_VALUE)
                sp[i] = -1;
        }
        return sp;
    }

    private static void relax(int[] sp, ArrayList<Integer> i, PriorityQueue<SVertex> pq, int v) {
        if (sp[v] + i.get(1) < sp[i.get(0)]) {
            //System.out.println("before " + pq);
            SVertex a = new SVertex(i.get(0), sp[i.get(0)]);
            //System.out.println(pq.remove(a));
            sp[i.get(0)] = sp[v] + i.get(1);
            a.w = sp[i.get(0)];
            pq.add(a);
            //System.out.println("after " + pq);
        }
    }

    public static void main(String[] args) {
       int V = 3;
        // Initialize the ArrayList
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        // Manually add the values from the 3D array
        adj.add(new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 1)),
                new ArrayList<>(Arrays.asList(2, 6))
        )));

        adj.add(new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(2, 3)),
                new ArrayList<>(Arrays.asList(0, 1))
        )));

        adj.add(new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 3)),
                new ArrayList<>(Arrays.asList(0, 6))
        )));
       int S = 2;

        //System.out.println(Arrays.toString(dijkstra(V, adj, S)));
    }
}
