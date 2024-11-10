public class MinAtleatKOR {
    public static int minimumSubarrayLength(int[] nums, int k) {
        int l = 0, r = 0;
        int minlength = Integer.MAX_VALUE, or = 0;
        for (r = 0; r < nums.length; r++) {
            or |= nums[r];

            if (or >= k) {
                minlength = Math.min(minlength,r-l+1);
                System.out.println("or exceded at r="+r+" = "+or);
                or = nums[r];
                int t = r;
                while (l < t && or <k) {
                    int tmp =(nums[t-1] | or);
                    System.out.println("or for t="+(t-1)+" = "+tmp);
                    if (tmp <= k) {
                        t--;
                    } else {
                        minlength = Math.min(minlength,r-t+2);
                        break;
                    }
                    or |= nums[t];
                    if (or == k)break;
                }
                System.out.println("exceeded or fixed => or = "+or+" r= "+r);
                //if (l == t)t++;
                System.out.println("t = "+t);
                l =t;
                if (or>=k){
                    minlength = Math.min(minlength,r-l+1);
                }
                System.out.println("now minl = "+minlength);
                System.out.println("now l = "+l);
            }

        }
        return minlength== Integer.MAX_VALUE ? -1:minlength;
    }
    public static void main(String[] args) {
        int[] nums = {1,32,55,53,52,52,54,2};
        int k =55;
        System.out.println(minimumSubarrayLength(nums,k));
        System.out.println(Integer.toBinaryString(32));
        System.out.println(Integer.toBinaryString(86));
        System.out.println(Integer.toBinaryString(2));
    }
}
