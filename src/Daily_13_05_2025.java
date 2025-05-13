public class Daily_13_05_2025 {
    private static final int mod = 1_000_000_007;

    public static int lengthAfterTransformations(String s, int t) {
        int[] dp = new int[t + 26];
        for (int i = 0; i < 26; i++)
            dp[i] = 1;
        for (int i = 26; i < t + 26; i++)
            dp[i] = (dp[i - 26] + dp[i - 25]) % mod;

        int ans = 0;
        for (char ch : s.toCharArray())
            ans = (ans + dp[ch - 'a' + t]) % mod;
        return ans;
    }

    public static void main(String[] args) {
        String s = "jqktcurgdvlibczdsvnsg";
        int t = 7517;
        System.out.println("out = " + lengthAfterTransformations(s, t));
    }
}
