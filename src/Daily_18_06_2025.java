import java.util.Arrays;

public class Daily_18_06_2025 {
    public static int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int len = 3;
        int[][] div = new int[n/len][len];
        int maxDiff = -1;
        for (int i=0;i<n/len;i++){
            int offset = i*len;
            System.arraycopy(nums, offset, div[i], 0, len);
            maxDiff = Math.max(maxDiff,div[i][len-1]-div[i][0]);
        }
        if(maxDiff>k)return new int[0][0];
        return div;
    }
    public static void main(String[] args) {
        int[] nums = {1,3,4,8,7,9,3,5,1};
        int k = 2;
        System.out.println(Arrays.deepToString(divideArray(nums, k)));
    }
}
