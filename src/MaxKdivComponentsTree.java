import java.util.ArrayList;

public class MaxKdivComponentsTree {

    public static int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);
        int cmp = 0;
        for (int i = 0; i < n; i++) {
            adj.add(i, new ArrayList<>());
        }
        for (int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        System.out.println(adj);

        return cmp;
    }

    public static void main(String[] args) {
        System.out.println("Satyam");
    }
}
