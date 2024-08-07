import java.util.Arrays;

public class RemoveDupFromSortedArr {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int p = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[p - 1] < nums[i])
                nums[p++] = nums[i];
        }
        return p;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,1,2,3,3,4,4};
        RemoveDupFromSortedArr obj = new RemoveDupFromSortedArr();
        System.out.println(Arrays.toString(Arrays.copyOf(arr, obj.removeDuplicates(arr))));
    }
}
