import java.util.PriorityQueue;

public class FindChampion {
    record Degree(int v, int deg) implements Comparable<Degree> {
        @Override
        public int compareTo(Degree o) {
            return this.deg - o.deg;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true; // Check for reference equality
            if (obj == null || getClass() != obj.getClass()) return false; // Type check
            Degree o = (Degree) obj; // Safe cast
            return this.v == o.v; // Compare based on v
        }

    }

    public static int findChampion(int n, int[][] edges) {
        PriorityQueue<Degree> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            pq.add(new Degree(i, 0));
        }

        int[] deg = new int[n];

        for (int[] i : edges) {
            int to = i[1];
            deg[to]++;
            System.out.println(pq.remove(new Degree(to,deg[to]-1)));

            pq.add(new Degree(to, deg[to]));
        }
        System.out.println(pq);
        Degree top = pq.poll();
        Degree sec = pq.poll();
        assert top != null;
        if (sec == null || top.deg != sec.deg) {

            return top.v;
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0,1},{1,2}};

        System.out.println(findChampion(n, edges));
    }
}
