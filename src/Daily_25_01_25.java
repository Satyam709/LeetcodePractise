import java.util.Arrays;
import java.util.Comparator;

public class Daily_25_01_25 {
    public static int[] lexicographicallySmallestArray(int[] nums, int limit) {
        Integer[] idx = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (i,j)->{
            if (nums[i] == nums[j])return i-j;
            return nums[i]-nums[j];
        });
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(idx));
        int i = 0;
        while (i< nums.length){
            if (idx[i]==i){
                i++;
                continue;
            }
            int t= i+1;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,7,6,18,2,1}; int limit = 3;
        System.out.println(Arrays.toString(lexicographicallySmallestArray(nums,limit)));
    }
}
