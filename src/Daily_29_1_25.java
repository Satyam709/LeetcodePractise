public class Daily_29_1_25 {
    public int[] findRedundantConnection(int[][] edges) {
        UF uf = new UF(edges.length+1);
        for (int[] i : edges){
            if (!uf.union(i[0],i[1]))return i;
        }
        return edges[0];
    }

    static class UF {
        private final int[] arr;
        private final int[] rank;

        public UF(int n) {
            arr = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i;
                rank[i] = 1;
            }
        }

        private int find(int u) {
            if (arr[u] != u)
                arr[u] = find(arr[u]);
            return arr[u];
        }

        private boolean union(int a, int b) {
            int ra = find(a);
            int rb = find(b);
            if (ra == rb) return false;

            if (rank[ra] > rank[rb]) {
                arr[rb] = ra;
            } else if (rank[ra] < rank[rb]) {
                arr[ra] = rb;
            } else {
                arr[ra] = rb;
                rank[rb]++;
            }
            return true;
        }
    }
}

