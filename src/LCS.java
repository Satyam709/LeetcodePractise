import java.util.Arrays;

public class LCS {
    public static int longestCommonSubsequence(String text1, String text2) {
        int i = text1.length(),j = text2.length();
        int[][] dp =new int[i+1][j+1];
        for (int k = 0; k < i+1; k++) {
            for (int l = 0; l < j+1; l++) {
                if (k == 0 || l ==0 )
                    dp[k][l] = 0;
                else dp[k][l] = -1;
            }
        }

        int out =  lcs(i,j,dp,text1,text2);
        System.out.println(Arrays.deepToString(dp));
    return out;
    }
    private static int lcs(int i ,int j,int[][] dp,String x,String y){
        if (i<0 || j<0)return 0;

        if (dp[i][j]!=-1)return dp[i][j];
        // 1 based indexing
        int val =x.charAt(i-1) == y.charAt(j-1)?1:0;

        return dp[i][j] =val+ Math.max(lcs(i-1,j-1,dp,x,y),Math.max(lcs(i-1,j,dp,x,y),lcs(i,j-1,dp,x,y)));
    }

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "mlk";
        System.out.println( longestCommonSubsequence(text1,text2));
    }
}
