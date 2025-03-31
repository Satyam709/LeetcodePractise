import java.util.Arrays;

public class Daily_31_03_2025 {
    public static long putMarbles(int[] weights, int k) {
        int n = weights.length;
        long[] arr = new long[n - 1];

        long minCost = 0;
        long maxCost = 0;

        for (int i = 0; i < n - 1; i++) {
            arr[i] = ((long) weights[i]) + weights[i + 1];
        }
        Arrays.sort(arr);

        for (int i = 0; i < k - 1; i++) {
            minCost += arr[i];
            maxCost += arr[n - 2 - i];
        }

        return maxCost - minCost;
    }

    public static void main(String[] args) {
        int[] weights = {1, 3, 5, 1};
        int k = 2;
        System.out.println(putMarbles(weights, k));
    }
}
