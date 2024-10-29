public class MaxSumSubsequenceDp {
    public static int maximumSumSubsequence(int[] nums, int[][] queries) {
        long sum = 0;
        for (int[] query : queries) {
            nums[query[0]] = query[1];
            sum += getMaxSum(nums);
        }
        return (int)sum%1000000007;
    }

    private static int getMaxSum(int[] nums) {
        int p = 0, s = 0, crnt = 0;

        for (int num : nums) {
            int t = p;
            if (num + s > p)
                p = num + s;
            s = t;
        }
        return p;
    }

    public static void main(String[] args) {
        int[] nums = {3,5,9};
        int[][] queries = {{1,-2},{0,-3}};

        System.out.println(maximumSumSubsequence(nums,queries));
    }
}
