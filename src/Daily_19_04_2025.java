import java.util.Arrays;

public class Daily_19_04_2025 {
    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            int lx = lower - nums[i], ux = upper - nums[i];
            int left = lowerBound(nums, lx, i + 1);
            int right = upperBound(nums, ux, i + 1) - 1;
            if (left <= right) {
                count += right - left + 1;
            }
        }
        return count;
    }

    // First index >= target
    private static int lowerBound(int[] arr, int target, int start) {
        int left = start, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    // First index > target
    private static int upperBound(int[] arr, int target, int start) {
        int left = start, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 7, 4, 4, 5};
        int lower = 3, upper = 6;

        System.out.println(countFairPairs(nums, lower, upper));
    }
}
