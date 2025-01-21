import java.util.Arrays;

public class Daily_21_01_25 {
    private static void solve(int[][] grid){
        int n = grid[0].length;
        long[] pre = new long[n];
        long[] post = new long[n];
        for (int i = 1; i < n; i++) {
            pre[i]= pre[i-1]+grid[1][i-1];
            post[n-i-1] = post[n-i] + grid[0][n-i];
        }
        System.out.println(Arrays.toString(post));
        System.out.println(Arrays.toString(pre));
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans,Math.max(pre[i],post[i]));
        }
        System.out.println("answer "+ans);
    }


    public static void main(String[] args) {
        int[][] grid = {{20,3,20,17,2,12,15,17,4,15},{20,10,13,14,15,5,2,3,14,3}};
        //System.out.println(gridGame(grid));
        System.out.println("goooooooooooooo heerrrrrrrrrrrr");
        solve(grid);
    }
}