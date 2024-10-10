import java.util.Arrays;
import java.util.Comparator;

public class MaxRamp {
    public static int maxWidthRamp(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length-1; i++) {

            int j = nums.length-1;
            while (j>i && nums[j]<nums[i])j--;
            max = Math.max(max,j-i);
        }
        return max;
    }

    public static int maxWidthRamp2(int[] nums) {

        Integer[] arr = new Integer[nums.length];

        // Fill arr with the indices
        for (int i = 0; i < nums.length; i++) {
            arr[i] = i;
        }

        // Sort arr based on the values in nums using indices
        Arrays.sort(arr, (i,j)->{
            if (nums[i]-nums[j] == 0)
                return Integer.compare(i,j);
            return nums[i]-nums[j];
        });
        System.out.println(Arrays.toString(arr));
        int min=arr[0],max = arr[nums.length-1];
        int width = 0;
        for (int i = 1 ;i<nums.length ;i++) {
            min = Math.min(min,arr[i]);
            width = Math.max(arr[i]-min,width);
        }
        return width;
    }

    public static void main(String[] args) {
        int[] nums = {9,8,1,0,1,9,4,0,4,1};
        System.out.println(maxWidthRamp2(nums));
    }
}
