public class JumpGame2 {
    public static int minJumps(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        int jump = 0, farthest = 0, currentEnd = 0;

        for (int i = 0; i < n; i++) {

            farthest = Math.max(nums[i] + i, farthest);

            if (i == currentEnd) {
                jump++;
                currentEnd = farthest;
            }

            if (currentEnd >= n - 1) break;
        }
        return jump;
    }

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {2, 3, 1, 1, 4};
        System.out.println("Minimum jumps for nums1: " + minJumps(nums1)); // Output: 2

        // Example 2
        int[] nums2 = {2, 3, 0, 1, 4};
        System.out.println("Minimum jumps for nums2: " + minJumps(nums2)); // Output: 2
    }
}
