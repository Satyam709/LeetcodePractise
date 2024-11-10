import java.util.Arrays;

public class SetBitsArr {
    public static boolean canSortArray(int[] nums) {
        int[] setBits = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            setBits[i] = getSetBits(nums[i]);
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if(nums[j]<nums[j-1])
                    if (setBits[j]!=setBits[j-1])
                        return false;
                    else swap(nums,j,j-1);
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(setBits));
        return true;
    }

    private static void swap(int[] n,int i,int j){
        int t = n[i];
        n[i] = n[j];
        n[j] = t;
    }

    private static int getSetBits(int n){
        int d = (int)(Math.log(n)/Math.log(2)) +1;
        int out = 0;
        for (int i = 0; i < d; i++) {
            out+=(n >> i) & 1 ;
        }
        return out;
    }

    public static void main(String[] args) {
        int[] arr = {8,4,2,30,15};
        System.out.println(canSortArray(arr));
    }
}
