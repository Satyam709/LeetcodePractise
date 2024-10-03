public class SumDivByP {
    public int minSubarray(int[] nums, int p) {

        long sum = 0;
        for (int i : nums)
            sum += i;
        if (sum < p) {
            return -1;
        }
        System.out.println("sum ="+sum);
        long rem = sum % p;

        System.out.println("rem="+rem);
        int out =nums.length;
        while (sum>rem){
            System.out.println("checking for "+rem);
            out = Math.min(lengthMinSubArr(nums, rem),out);
            rem+=p;
        }

        return out == nums.length ? -1:out;
    }

    private int lengthMinSubArr(int[] nums, long p) {
        if (p == 0) return 0;
        int min = nums.length;
        int crntSum = 0;
        int l = 0, r = 0;
        for (r = 0; r < nums.length; r++) {
            crntSum += nums[r];

            while (l < r && crntSum > p) {
                crntSum -= nums[l];
                l++;
            }

            if (crntSum == p) {
                min = Math.min(r - l + 1, min);
            }
//            System.out.println("min at r "+r+" = "+min);
//            System.out.println("crntSum = "+crntSum);
        }
        return min;
    }

    public static void main(String[] args) {
        int[] arr = {26,19,11,14,18,4,7,1,30,23,19,8,10,6,26,3};
        int p = 26;

        SumDivByP obj = new SumDivByP();
        System.out.println(obj.minSubarray(arr, p));
    }
}
