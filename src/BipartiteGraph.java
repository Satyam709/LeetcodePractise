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

    public static void main(String[] args) {
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(isBipartite(graph));
    }
}
