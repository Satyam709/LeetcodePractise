import java.util.Arrays;

public class Weekly138 {
    public int[] resultsArray(int[] nums, int k) {
        if (k == 1)
            return nums;

        int[] rank = new int[nums.length - k + 1];
        int sr = 0;

        for (int i = 0; sr + k - 1 < nums.length; i++) {
            if (i < nums.length - 1 && nums[i + 1] == nums[i] + 1) {  // k>1
                if (i + 1 == sr + k - 1) {
                    rank[sr] = nums[sr + k - 1];
                    sr++;
                }
            } else {
                while (sr< rank.length && sr < i+1) {
                    rank[sr] = -1;
                    sr++;
                }
            }
        }
        return rank;
    }

    public static void main(String[] args) {
        int arr[] = {4, 3, 1, 2, 3, 4, 5, 5, 6, 5};
        int k = 4;

        Weekly138 obj = new Weekly138();
        System.out.println(Arrays.toString(obj.resultsArray(arr, k)));
    }
}
