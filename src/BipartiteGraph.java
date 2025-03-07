import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    public static boolean isBipartite(int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        int[] color = new int[graph.length];
        Arrays.fill(color,-1);
        for (int j = 0; j < graph.length; j++) {
            if (color[j] == -1){
                q.add(j);
                color[j]=0;
                while (!q.isEmpty()){
                    int top = q.poll();
                    for(int i : graph[top]){
                        if (color[top] == color[i]){
                            System.out.println("clashed at :\ntop ="+top+" to = "+i);
                            return false;
                        }
                        if (color[i] == -1){
                            q.add(i);
                            color[i] = 1^color[top];
                        }
                    }
                }
            }
        }
        return true;
    }


    public static boolean isBipartite2(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color,-1);
        for (int j = 0; j < graph.length; j++) {
            if (color[j] == -1){
                color[j] = 0;
                if (!dfs(graph,color,j,-1))return false;
            }
        }
        return true;
    }

    private static boolean dfs(int[][] graph ,int[] color , int v,int p){
        if (p!=-1 && color[v] != -1){
            return true;
        }
        if (p!=-1)
            color[v] = 1^color[p];
        for (int i:graph[v]){
            if (color[i] == -1){
                if (!dfs(graph,color,i,v))return false;
            } else if (color[i] == color[v]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(isBipartite(graph));
        System.out.println(isBipartite2(graph));
    }
}
