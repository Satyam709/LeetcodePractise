public class UniquePathsDp {
    static class MethodOneMaths {
        public int uniquePaths(int m, int n) {
            // ans is : 'k C r' where k = m-1 + n-1 and r is n-1 or m-1
            m--;
            n--;
            return (int) com(m + n, m);
        }

        private int com(int n, int r) {
            double fact = 1;
            int m = n - r;
            if (m < 0) return -1;
            double max = Math.max(r, m);
            double min = Math.min(r, m);

            for (int i = 1; i <= min; i++) {
                fact *= (max + i) / i;
            }
            return (int) Math.round(fact);
        }
    }


    static class MethodDP {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            dp[0][0] = 1;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j - 1 >= 0) {
                        dp[i][j] += dp[i][j - 1];
                    }
                    if (i - 1 >= 0) {
                        dp[i][j] += dp[i - 1][j];
                    }
                }
            }
            return dp[m - 1][n - 1];
        }

        public int uniquePathsWithObstacles(int[][] obstacleGrid) {

            int m = obstacleGrid.length;
            int n = obstacleGrid[0].length;

            int[][] dp = new int[m][n];
            dp[0][0] = 1;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    // skip the obstacle
                    if (obstacleGrid[i][j] == 1) continue;

                    if (j - 1 >= 0 && obstacleGrid[i][j - 1] != 1) {
                        dp[i][j] += dp[i][j - 1];
                    }
                    if (i - 1 >= 0 && obstacleGrid[i - 1][j] != 1) {
                        dp[i][j] += dp[i - 1][j];
                    }
                }
            }
            return dp[m - 1][n - 1];
        }
    }

    public static void main(String[] args) {
        UniquePathsDp.MethodOneMaths obj = new UniquePathsDp.MethodOneMaths();
        UniquePathsDp.MethodDP obj2 = new UniquePathsDp.MethodDP();
        int m = 10;
        int n = 10;
        System.out.println("maths = " + obj.uniquePaths(m, n));
        System.out.println("dp = " + obj2.uniquePaths(m, n));
    }
}
