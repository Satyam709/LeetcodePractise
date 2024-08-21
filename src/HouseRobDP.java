import java.util.Arrays;

public class HouseRobDP {
    public int rob(int[] nums) {

        int[] dp = new int[nums.length + 1];

        Arrays.fill(dp,-1);
        int ans =  Math.max(dpFind(dp, nums, nums.length),dpFind(dp, nums, nums.length-1));
        System.out.println(Arrays.toString(dp));
        return ans;
    }

    private int dpFind(int[] dp, int[] nums, int n) {

        if (n < 1) return 0;

        if (n>nums.length)return 0;

        if (dp[n] != -1) return dp[n];

        int ahead = 0, behind = 0;

        for (int i = 2; i <= n; i++) {
            behind = Math.max(behind, dpFind(dp, nums, n - i));
        }
        return dp[n] = Math.max(ahead + behind, 0) + nums[n-1];
    }

    public static void main(String[] args) {
        HouseRobDP obj = new HouseRobDP();
        int[] arr = {1,2,3,1};
        System.out.println(obj.rob(arr));
    }
}
