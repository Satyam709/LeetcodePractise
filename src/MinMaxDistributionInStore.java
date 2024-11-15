import java.util.Arrays;
import java.util.OptionalInt;

public class MinMaxDistributionInStore {
    public static int minimizedMaximum(int n, int[] quantities) {
        return getMinDistribution(quantities,n);
    }

    private static int getMinDistribution(int[] q, int n) {
        OptionalInt max = Arrays.stream(q).max();
        if (max.isEmpty()) return -1;

        int lw = 1;
        int hi = max.getAsInt();
        int mid;
        int lastValid = -1;

        while (lw <= hi) {
            mid = lw + (hi - lw) / 2;
            if (isDistributionValid(q, n, mid)) {
                lastValid = mid;
                hi = mid - 1;
            } else {
                lw = mid + 1;
            }
        }
        return lastValid;
    }


    private static boolean isDistributionValid(int[] q, int n, int x) {
        for (int i:q){
            n -= (int)Math.ceil((float)i/x);
            if (n<0)return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] quantities = {11, 6};
        System.out.println(minimizedMaximum(n,quantities));
    }

}