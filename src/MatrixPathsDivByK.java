import java.util.Arrays;

public class MatrixPathsDivByK {
    public static int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int MOD = (int) (1e9 + 7);

        int[][][] dp = new int[m][n][k];
        dp[0][0][grid[0][0] % k] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int crnt = grid[i][j] % k;
                for (int l = 0; l < k; l++) {
                    // try left
                    if (j > 0) {
                        dp[i][j][(l + crnt) % k] = (int) ((long) dp[i][j][(l + crnt) % k] + dp[i][j - 1][l]) % MOD;
                    }

                    // try up
                    if (i > 0) {
                        dp[i][j][(l + crnt) % k] = (int) ((long) dp[i][j][(l + crnt) % k] + dp[i - 1][j][l]) % MOD;
                    }
                }
            }
        }
        System.out.println("arr : \n" + Arrays.deepToString(dp));
        return dp[m - 1][n - 1][0];
    }

    public static void main(String[] args) {
        int[][] grid = {{5, 2, 4}, {3, 0, 5}, {0, 7, 2}};
        int k = 3;
        System.out.println("Out = " + numberOfPaths(grid, k));
    }
}
