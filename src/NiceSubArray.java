public class NiceSubArray {
    public int numberOfSubarrays(int[] nums, int k) {
        return getCountFor(nums, k) - getCountFor(nums, k - 1);
    }

    private int getCountFor(int[] nums, int k) {

        if (k < 0) return 0;

        int count = 0;
        int freq = 0, l = 0, r = 0;

        while (r < nums.length) {

            if (nums[r] % 2 != 0)
                freq++;

            while (freq > k) {
                if (nums[l] % 2 != 0)
                    freq--;
                l++;
            }

            // freq<=k
            count += r - l + 1;
            r++;

        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        NiceSubArray obj = new NiceSubArray();

        System.out.println(obj.numberOfSubarrays(nums,k));
    }
}
