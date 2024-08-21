import java.util.Arrays;

public class MinSumMatrixPath {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0 && j==0)continue;
                int left =Integer.MAX_VALUE ,up=Integer.MAX_VALUE;
                if (i-1>=0){
                    up = dp[i-1][j];
                }
                if (j-1>=0){
                    left = dp[i][j-1];
                }
                dp[i][j] = grid[i][j]+Math.min(up,left);
            }
            System.out.println(Arrays.deepToString(dp));
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        MinSumMatrixPath obj = new MinSumMatrixPath();
        System.out.println(obj.minPathSum(grid));
    }
}
