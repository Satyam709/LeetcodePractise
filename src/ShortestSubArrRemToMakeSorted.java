import java.util.Arrays;
import java.util.Map;

public class ShortestSubArrRemToMakeSorted {
    public static int findLengthOfShortestSubarray(int[] arr) {

        System.out.println(Arrays.toString(arr));

        int l = 0, r = arr.length - 1;
        boolean gotL = false, gotR = false;

        while ((!gotL || !gotR) && l < r) {
            if (!gotL && arr[l] <= arr[l + 1]) l++;
            else gotL = true;
            if (!gotR && arr[r] >= arr[r - 1]) r--;
            else gotR = true;
        }

        System.out.println("left = " + l + " , right = " + r);
        int min = arr.length-l-1;
        while (r < arr.length) {
            int t = getCommon(arr, 0, l, arr[r]);
            System.out.println("got pivot form left = " + t + " for r = " + r + " at = " + arr[r]);
            min = Math.min(min, (r - t - 1));
            r++;
        }


        return Math.max(min,0);
    }

    private static int getCommon(int[] arr, int lw, int hi, int k) {
        int mid, ladtValid = -1;
        while (lw <= hi) {
            mid = lw + (hi - lw) / 2;
            if (arr[mid] > k) hi = mid - 1;
            else {
                ladtValid = mid;
                lw = mid + 1;
            }
        }
        return ladtValid;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 10, 4, 2, 3, 5};
        int[] arr2 = {1, 2, 11, 10, 4, 2, 3, 5};
        int[] arr3 = {5, 4, 3, 2, 1};
        int[] arr4 = {1, 2, 3};
        int[] arr5 = {1, 2, 3, 3, 3, 3, 3, 11, 10, 4, 2, 3, 5};
        int[] arr6  = {10,13,17,21,15,15,9,17,22,22,13};
        System.out.println("test 1 -> " + findLengthOfShortestSubarray(arr));
        System.out.println("test 2 -> " + findLengthOfShortestSubarray(arr3));

        System.out.println("test 3-> " + findLengthOfShortestSubarray(arr4));
        System.out.println("test 4 -> " + findLengthOfShortestSubarray(arr2));
        System.out.println("test 5 -> " + findLengthOfShortestSubarray(arr5));

        System.out.println("test 6 -> " + findLengthOfShortestSubarray(arr6));
    }
}
