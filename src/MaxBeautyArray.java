import java.util.HashMap;

public class MaxBeautyArray {
    public static int maximumBeauty(int[] nums, int k) {
        int largest = Integer.MIN_VALUE, smallest = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();

        int max = -1;

        for (int num : nums) {

            for (int j = -k; j <= k; j++) {
                int v = map.getOrDefault(num + j, 0);
                map.put(num + j, v + 1);
                max = Math.max(v + 1, max);
            }
            System.out.println(map);

        }


        return max;
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 1, 2};
        int k = 2;
        System.out.println(maximumBeauty(nums,k));
    }
}

