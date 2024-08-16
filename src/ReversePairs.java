import java.util.Arrays;
import java.util.Comparator;

public class ReversePairs {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        int totalPAir =0 ;
        Integer[] ref = new Integer[n];
        for (int i = 0; i < n; i++) {
            ref[i] = i;
        }
        System.out.println("Original arr :"+Arrays.toString(nums));
        Arrays.sort(ref, (i, j) -> Integer.compare(nums[i], nums[j]));
        System.out.println("Sorted arr :"+Arrays.toString(ref));


        // search for right
        int right = 1,left =0 ;
        while (right<n && nums[ref[right]]<=2*nums[ref[0]])right++;
        for (int i = right; i < n; i++) {
            while (left<right && nums[ref[right]]>2*nums[ref[left]]) {

                System.out.println("pair = l:"+nums[ref[left]]+"r:"+nums[ref[right]]);

                if (ref[right]<ref[left])
                    totalPAir+=ref[left] - ref[right];

                left++;
            }
            right++;
        }

        return totalPAir;
    }


    public static void main(String[] args) {
        ReversePairs obj = new ReversePairs();

        int[] nums = {1,3,2,3,1};
        int[] nums2 = {2,4,3,5,1};
        System.out.println(obj.reversePairs(nums2));
    }
}
