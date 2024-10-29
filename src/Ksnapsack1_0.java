import java.util.Arrays;

public class Ksnapsack1_0 {
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Change in the given tree itself.
         * No need to return or print the output.
         * Taking input and printing output is handled automatically.
         */
        int N = 1000, W = 100;
        int[][] dp = new int[N][W + 1];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        return getKnapsack(weight, dp, value, value.length-1, maxWeight);
    }

    private static int getKnapsack(int[] weight, int[][] dp, int[] val, int i, int w) {
        if (dp[i][w] != -1) return dp[i][w];

        if (i == 0) {
            if (w >= weight[i])
                dp[i][w] = val[0];
            return dp[i][w] = Math.max(dp[i][w], 0);
        }

        // take
        if (w >= weight[i])
            dp[i][w] = val[i] + getKnapsack(weight, dp, val, i - 1, w - weight[i]);
        //not take and return max
        return dp[i][w] = Math.max(dp[i][w], getKnapsack(weight, dp, val, i - 1, w));
    }

    public static void main(String[] args) {
        int[] w = {1, 2, 4, 5};
        int[] val = {5, 4, 8, 6};
        System.out.println(knapsack(w,val, val.length, 5));
    }
}
