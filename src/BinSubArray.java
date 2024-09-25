public class BinSubArray {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int sum = 0;
        int left = 0;

        // Traverse with the right pointer
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            // Adjust the left pointer when the sum exceeds the goal
            while (sum > goal && left <= right) {
                sum -= nums[left];
                left++;
            }

            // If the sum equals the goal, increment count
            if (sum == goal) {
                count++;
            }

            // Count additional subarrays with zeroes
            int tempLeft = left;
            while (sum == goal && tempLeft < right && nums[tempLeft] == 0) {
                count++;
                tempLeft++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 1};
        int k = 2;
        BinSubArray obj = new BinSubArray();
        System.out.println(obj.numSubarraysWithSum(arr, k));  // Output: 4
    }
}
