import java.util.Arrays;

public class MaxSum3NonOverlappingSubArr {
    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] result = new int[3];

        int[] map = new int[nums.length - k + 1];
        int c = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            c++;
            if (c == k) {
                map[i - k + 1] = sum;
                c--;
                sum -= nums[i - k + 1];
            }
        }

        System.out.println(Arrays.toString(map));

        int[] dp = new int[nums.length + 1];
        dp[k] = 0;

        for (int i = k + 1; i <= nums.length; i++) {
            dp[i] = dp[i - 1];
            if (map[dp[i - 1]] < map[i - k])
                dp[i] = i - k;
        }
        System.out.println(Arrays.toString(dp));
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 6, 7, 5, 1};
        int k = 2;
        System.out.println(Arrays.toString(maxSumOfThreeSubarrays(nums, k)));
    }
}
