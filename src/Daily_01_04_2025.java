import java.util.Arrays;

public class Daily_01_04_2025 {
    public static long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        int t;
        dp[n-1] = questions[n-1][0];
        for (int i = n-2; i >=0; i--) {
            t =questions[i][1]+i+1;
            dp[i] = Math.max(questions[i][0] + (t<n?dp[t]:0),dp[i+1]);
        }
        return dp[0];
    }
    public static void main(String[] args) {
        int[][] questions = {{3,2},{4,3},{4,4},{2,5}};
        System.out.println(mostPoints(questions));
    }
}
