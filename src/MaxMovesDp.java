import java.util.Arrays;

public class MaxMovesDp {
    public static int maxMoves(int[][] grid) {
        int m = grid.length;
        ;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int max = 0;

        for (int j = 1; j < n; j++) {
            boolean isAny = false;
            for (int i = 0; i < m; i++) {
                for (int k = i - 1; k <= i + 1; k++) {
                    if (k >= 0 && k < m && grid[k][j - 1] < grid[i][j]) {
                        if (j>1 && dp[k][j-1] == 0) {
                            System.out.println("got here");
                            continue;
                        }
                        System.out.println("hey i=" + i + " j=" + j);
                        isAny = true;
                        dp[i][j] = Math.max(dp[i][j], dp[k][j - 1] + 1);
                        max = Math.max(max, dp[i][j]);
                    }
                }
            }
            if (!isAny)return max;
        }
        System.out.println(Arrays.deepToString(dp));
        return max;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,4,3,5},{5,4,9,3},{3,4,2,11},{10,9,13,15}};
        //int[][] grid = {{3, 2, 4}, {2, 1, 9}, {1, 1, 7}};
        System.out.println(maxMoves(grid));
    }
}
