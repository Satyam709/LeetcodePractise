import java.util.Arrays;
import java.util.HashMap;

public class KthDistinctString {
    public static String kthDistinct(String[] arr, int k) {
        HashMap<String, Boolean> words = new HashMap<>(arr.length);

        for (String i : arr) {
            words.compute(i, (key, v) -> v == null);
        }
        int t = 0;
        for (String i : arr) {
            if (words.get(i)) {
                t++;
                if (t == k) return i;
            }

        }
        return "";
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = 0, j = 0, k = 0;

        int[] nums = Arrays.copyOf(nums1, m);
        while (i != m && j != n) {
            if (nums[i] <= nums2[j])
                nums1[k++] = nums[i++];
            else
                nums1[k++] = nums2[j++];
        }
        while (i != m) {
            nums1[k++] = nums[i++];
        }
        while (j != n) {
            nums1[k++] = nums2[j++];
        }
    }

    public static int removeElement(int[] nums, int val) {
        int gt = nums.length -1;
        int i = 0;
        while (i <= gt)
            if (nums[i] == val )
                swap(nums, i, gt--);
            else
                i++;
        return i;
    }

    private static void swap(int[] nums, int i, int gt) {
        int t = nums[i];
        nums[i] = nums[gt];
        nums[gt] = t;
    }

    public static void main(String[] args) {
        String[] arr = {"d", "b", "c", "b", "c", "a"};
        String[] arr1 = {"aaa", "aa", "a"};
        //System.out.println(kthDistinct(arr1, 1));


//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int[] nums2 = {1, 4, 5};
//        merge(nums1, 3, nums2, 3);
//        System.out.println(Arrays.toString(nums1));

        int[] a = {0};
        removeElement(a,0);
    }


}
