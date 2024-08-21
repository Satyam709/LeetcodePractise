public class GeekTrainingDp {
    public int maximumPoints(int[][] arr, int N) {
        int n = arr.length;
        int totalAct = arr[0].length;
        int[][] dp = new int[n][totalAct];

        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {

            dp[i][0] = arr[i][0] + Math.max(dp[i - 1][1], dp[i - 1][2]);

            dp[i][1] = arr[i][1] + Math.max(dp[i - 1][0], dp[i - 1][2]);

            dp[i][2] = arr[i][2] + Math.max(dp[i - 1][0], dp[i - 1][1]);

        }



        return Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
    }

    public static void main(String[] args) {
        GeekTrainingDp obj = new GeekTrainingDp();

        int[][] arr = {{1, 2, 5},
                {3, 1, 1},
                {3, 2, 3}};
        int n =3;

        System.out.println(obj.maximumPoints(arr,n));
    }
}
