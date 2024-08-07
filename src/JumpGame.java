import java.util.Arrays;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int curnt = nums.length-1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i]+i>=curnt)
                curnt =i;
        }
        return curnt == 0;
    }

    public static void main(String[] args) {
        //int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {3, 2, 1, 0, 4};
        JumpGame obj = new JumpGame();
        System.out.println(obj.canJump(nums));
    }
}
