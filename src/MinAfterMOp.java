import java.util.Arrays;
import java.util.OptionalInt;

public class MinAfterMOp {
    public static int minimumSize(int[] nums, int maxOperations) {
        OptionalInt x = Arrays.stream(nums).max();

        int lw = 1, up = x.getAsInt();
        int last = up;
        while (lw <= up) {
            int mid = lw + up / 2;
            if (isPossible(maxOperations, mid, nums)) {
                last = mid;
                up = mid - 1;
            } else {
                lw = mid + 1;
            }
        }
        return last;
    }

    private static boolean isPossible(int op, int x, int[] arr) {
        for (int i : arr) {
            if (i > x) {
                op -= (int) (Math.ceil((i * 1.0) / x)) - 1;
            }
            if (op < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {9};
        int maxOperations = 2;

        System.out.println(minimumSize(nums,maxOperations));
    }
}
