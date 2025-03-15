import java.util.Arrays;

public class Daily_15_03_2025 {
    public static int minCapability(int[] nums, int k) {
        int lw = 1 , up = (int)1e6;
        int lv = -1;
        while (lw<=up){
            int mid = (lw + up) /2;
            if (isValid(nums,mid,k)){
                up = mid-1;
                lv = mid;
            }else lw = mid+1;
        }
        return lv;
    }
    private static boolean isValid(int[] arr,int x,int k){
        System.out.println("mid = "+x);
        int[] dp = new int[arr.length+2];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+ (arr[i-2]<=x?1:0));
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length-1]>=k;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        int k = 2;
        System.out.println(minCapability(nums,k));
    }
}
