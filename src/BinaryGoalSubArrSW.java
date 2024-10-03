public class BinaryGoalSubArrSW {

    public static int numSubarraysWithSum(int[] nums, int goal) {
        return countSubArraysForLessThan(nums,goal)-countSubArraysForLessThan(nums,goal-1);
    }

    private static int countSubArraysForLessThan(int[] arr, int k) {
        if (k<0)return 0;
        int l = 0;
        int subArr = 0;
        int sum = 0;
        for (int r = 0; r < arr.length; r++) {
            sum += arr[r];


            while (sum > k) {
                sum -= arr[l];
                l++;
            }

            subArr += r - l + 1;

        }
        return subArr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 1};
        int goal = 2;

        System.out.println(numSubarraysWithSum(arr,goal));

    }
}
