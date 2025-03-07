import java.util.HashSet;

public class Daily_01_03_2025 {
    public static String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = str1.charAt(0) == str2.charAt(0) ? 1 : 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = i > 0 && j > 0 ? dp[i - 1][j - 1] + 1 : 1;
                } else {
                    dp[i][j] = Math.max(i > 0 ? dp[i - 1][j] : 0, j > 0 ? dp[i][j - 1] : 0);
                }
            }
        }
        System.out.println("lcs length = " + dp[n - 1][m - 1]);
        // get the string
        int lcs = dp[n-1][m-1];
        StringBuilder out = new StringBuilder(n+m-lcs);
        int i = n - 1, j = m - 1;
        while (i >= 0 && j >= 0) {
            if (str1.charAt(i) == str2.charAt(j)) {
                out.append(str1.charAt(i));
                i--;
                j--;
            } else if (i > 0 && dp[i - 1][j] >= (j > 0 ? dp[i][j - 1] : 0)) {
                out.append(str1.charAt(i));
                i--;
            } else {
                out.append(str2.charAt(j));
                j--;
            }
        }

        while (i >= 0) out.append(str1.charAt(i--));
        while (j >= 0) out.append(str2.charAt(j--));

        return out.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(shortestCommonSupersequence("abac", "cab"));
    }
}
