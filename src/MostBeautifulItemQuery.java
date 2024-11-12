import java.util.Arrays;
import java.util.Comparator;

public class MostBeautifulItemQuery {
    public static int[] maximumBeauty(int[][] items, int[] queries) {
        int[] out = new int[queries.length];
        Arrays.sort(items, Comparator.comparingInt(i -> i[0]));

        System.out.println(Arrays.deepToString(items));
        int maxTill = 0;

        for (int i = 0; i < items.length; i++) {
            maxTill = Math.max(items[i][1],maxTill);
            items[i][1] = maxTill;
        }
        System.out.println(Arrays.deepToString(items));
        for (int i = 0; i < out.length; i++) {
            out[i] = query(items,queries[i]);
        }
        return out;
    }

    private static int query(int[][] items, int q) {
        int lw = 0, up = items.length - 1;
        int maxVal = 0;
        int lastOccured = -1;
        while (lw <= up) {
            int mid = lw + (up - lw) / 2;
            if (items[mid][0]>q)up = mid-1;
            else{
                maxVal = Math.max(maxVal,items[mid][1]);
                lastOccured = items[mid][1];
                lw = mid+1;
            }
        }
        return lastOccured;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,2},{3,2},{2,4},{5,6},{3,5}};
        int[] queries = {1,2,3,4,5,6};
        System.out.println(Arrays.toString(maximumBeauty(arr, queries)));
    }
}
