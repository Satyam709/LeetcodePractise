import java.util.HashSet;

public class Daily_22_03_2025 {
    public int countCompleteComponents(int n, int[][] edges) {
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            graph[i][i] = 1;
        }
        for (int[] i : edges){
            int u = i[0];
            int v = i[1];
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        HashSet<Integer> visited = new HashSet<>();
        int count= 0 ;
        outer: for (int i = 0; i < n; i++) {
            if (!visited.contains(i)){
                HashSet<Integer> cv = getComponentVertices(i, graph);
                visited.addAll(cv);
                for (int k: cv){
                    for (int j :cv) {
                        if (graph[k][j] != 1) {
                            continue outer;
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
    private HashSet<Integer> getComponentVertices(int v, int[][] graph){
        HashSet<Integer> bag = new HashSet<>();
        dfs(graph,v,bag);
        return bag;
    }
    private void dfs(int[][] graph , int v,HashSet<Integer> bag){
        if (bag.contains(v))return;
        bag.add(v);
        for (int i = 0; i < graph.length; i++){
            if (graph[v][i] == 1 &&  !bag.contains(i)){
                dfs(graph,i,bag);
            }
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0,1},{0,2},{1,2},{3,4},{3,5}};
        Daily_22_03_2025 obj = new Daily_22_03_2025();
        System.out.println(obj.countCompleteComponents(n,edges));
    }
}
