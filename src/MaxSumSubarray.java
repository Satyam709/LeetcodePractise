import java.util.List;

public class MaxSumSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0], crntSum = 0;
        for (int num : nums) {
            crntSum += num;
            maxSum = Math.max(crntSum, maxSum);
            if (crntSum < 0) crntSum = 0;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        MaxSumSubarray obj = new MaxSumSubarray();
        System.out.println(obj.maxSubArray(nums));
    }
}
