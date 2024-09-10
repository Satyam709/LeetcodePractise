import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MaxConsecutiveOnes {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, zero = 0;
        while (right < nums.length) {
            if (nums[right] == 0)
                zero++;
            right++;

            if (zero > k) {
                if (nums[left] == 0) zero--;
                left++;
            }
        }
        return right - left;
    }

    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 1};
        int k = 3;
        MaxConsecutiveOnes obj = new MaxConsecutiveOnes();

        System.out.println(obj.longestOnes(arr, k));
    }
}
