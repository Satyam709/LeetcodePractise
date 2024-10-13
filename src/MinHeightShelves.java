import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class MinHeightShelves {
    public int minHeightShelves(int[][] books, int shelfWidth) {

        int[] dp = new int[books.length+1];
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= books.length ; i++) {

            for (int j = i,w = 0, h = 0; j > 0 && w + books[j-1][0] <= shelfWidth  ; j--,w+=books[j-1][0]) {
            h = Math.max(h,books[j-1][1]);

            dp[i-1] = Math.min(dp[i-1],dp[j-1]+h);
            }

        }

        return dp[books.length];
    }
}
