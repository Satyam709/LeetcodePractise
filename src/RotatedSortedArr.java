import java.util.Arrays;

public class RotatedSortedArr {
    public int search(int[] nums, int target) {

        if (target == nums[0])return 0;

        int lw = 0, hi = nums.length - 1;

        boolean isRight = target<nums[0];

        while (lw <= hi) {
            int mid = lw + (hi - lw) / 2;
            int mi = nums[mid];
            if (mi<nums[0]){

                if (isRight){
                    if (mi<target){
                        lw = mid+1;
                    } else if (mi>target) {
                        hi = mid-1;
                    }
                    else return mid;
                }
                else {
                    hi = mid-1;
                }

            } else if (nums[mid]>nums[nums.length-1]) {

                if (!isRight){
                    if (mi<target){
                        lw = mid+1;
                    } else if (mi>target) {
                        hi = mid-1;
                    }
                    else return mid;
                }
                else {
                    lw=mid+1;
                }
            }
            else{
                if (mi<target){
                    lw = mid+1;
                } else if (mi>target) {
                    hi = mid-1;
                }
                else return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {5,1};
        RotatedSortedArr obj = new RotatedSortedArr();
        System.out.println(obj.search(arr,5));
    }
}
