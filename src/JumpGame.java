import java.util.Arrays;

public class JumpGame {
    public boolean canJump(int[] nums) {

        jump(nums, 0);
        System.out.println(Arrays.toString(nums));
        return nums[nums.length - 1] == -1;
    }

    private void jump(int[] arr, int i) {
        if (arr[arr.length - 1] == -1) return;
        if (arr[i] == -1) return;
        int t = arr[i];
        arr[i] = -1;
        if (i+t>=arr.length) t= arr.length-1-i;
        for (int j = t; j >= 1; j--) {
            int ni = i + j;
            if (ni < arr.length)
                jump(arr, ni);
            else return;
        }
    }

    public static void main(String[] args) {
        //int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {3,2,1,0,4};
        JumpGame obj = new JumpGame();
        System.out.println(obj.canJump(nums));
    }
}
