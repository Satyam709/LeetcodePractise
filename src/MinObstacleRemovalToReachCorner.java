import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinObstacleRemovalToReachCorner {
    public static int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int target = m*n-1;


        int[][] dp = new int[m][n];
        for (int[] i:dp) {
            Arrays.fill(i,Integer.MAX_VALUE);
        }


        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        dp[0][0] = grid[0][0];
        System.out.println("dp = "+ Arrays.deepToString(dp));

        boolean[] visited = new boolean[m*n];

        pq.add(new int[]{0,dp[0][0]});

        while (!pq.isEmpty()){

            int[] polled = pq.poll();
            int v = polled[0];
            int w = polled[1];

            if (visited[v])continue;

            int[] di = get2D(v, n);
            visited[v] = true;
            System.out.println("v="+v);
            System.out.println("di = "+ Arrays.toString(di));

            if (v == target) {
                System.out.println("found");
                break;
            }
            // all 4 neighbours

            int i = di[0];
            int j = di[1];

            relax(i-1,j,dp,grid,pq,visited,w);
            relax(i+1,j,dp,grid,pq,visited,w);
            relax(i,j-1,dp,grid,pq,visited,w);
            relax(i,j+1,dp,grid,pq,visited,w);

        }

        return dp[m-1][n-1];
    }

    private static void relax(int i,int j,int[][] dp,int[][] grid,PriorityQueue<int[]> pq,boolean[] visited,int w){
        int m = grid.length;
        int n = grid[0].length;

        if (isValid(i,j,m,n) && !visited[get1D(i,j,n)]) {
            if (w+grid[i][j] < dp[i][j]) {
                System.out.println("i="+i+"j="+j+" relaxed");
                dp[i][j] = w + grid[i][j];
                System.out.println("relaxed val ="+dp[i][j]);
                pq.add(new int[]{get1D(i, j, n),dp[i][j]});
            }
        }
    }


    private static boolean isValid(int i ,int j,int m,int n){
        return i<m && i>=0 && j>=0 && j<n;
    }

    private static int get1D(int i,int j,int n){
        return i*n+j;
    }
    private static int[] get2D(int i, int n){
        int a = i/n;
        int b = i%n;

        return new int[]{a,b};
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,1},{1,1,0},{1,1,0}};
        int[][] grid2 = {{0,1,1,0,0},{0,1,0,1,0},{0,0,0,1,0}};
//        System.out.println("out = "+minimumObstacles(grid));
        System.out.println("out = "+minimumObstacles(grid2));
        //System.out.println(Arrays.toString(get2D(5, 3, 5)));
    }
}
