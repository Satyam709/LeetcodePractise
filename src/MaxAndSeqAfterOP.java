import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxAndSeqAfterOP {
    private static class comaprator implements Comparator<int[]> {
        @Override
        public int compare(int[] arg0, int[] arg1) {
            // {val,op}
            if (arg0[1] == arg1[1]) {
                // have to keep min at top
                return Integer.compare(arg0[0], arg1[0]);
            }
            if (arg0[1] > arg1[1]) {
                return -1;
            }
            return +1;
        }
    }

    public static int maximumAND(int[] nums, int k, int m) {
        Arrays.sort(nums);

        int remOp = k;
        int[] nums2 = nums;
        int and = 0;
        for (int i = 30; i >= 0 && remOp > 0; i--) {
            // {val,op}
            int target = 1 << i;
            PriorityQueue<int[]> pq = new PriorityQueue<>(new comaprator());
            int tm = m; // denotes the temp resized 'm'
            for (int j = 0; j < nums2.length; j++) {
                // if nums[j] > 0 target than the bit is already
                // set take it as zero
                int opReq = Math.max(0, target - nums2[j]);

                // if pq is full but there is a extra element with zero op=> take tis
                // this will be eventually filteredout and if not this will not effect the and
                // inc size of pq to accomodate this for sure
                pq.add(new int[] { nums2[j], opReq });
                if (pq.size() > tm) {
                    int[] polled = pq.poll();
                    if (polled[1] == 0) {
                        tm++;
                        pq.add(polled);
                    }
                    System.out.println("size reached polled = " + Arrays.toString(polled));
                }
            }

            // now lets take and sum the top m
            long sum = 0;
            int[] newAr = new int[tm];
            int l = 0;
            while (!pq.isEmpty()) {
                int[] polled = pq.poll();
                sum += polled[1];
                newAr[l++] = polled[0] + polled[1]; // perform the op
            }
            System.out.println();

            System.out.println("remOP= " + remOp);
            if (sum <= remOp) {
                // this subset is possible

                // now we will just look on this
                nums2 = newAr;

                // account this in and
                and |= target;

                // update rem op
                remOp -= sum;
            } else {
                // if sum > k; means not possible to take out m elements so give
                // whole another pass for next bits
            }
            // but ya unset this bit from every number
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] >= target) {
                    nums2[j] -= target;
                }
            }
        }
        return and;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2 };
        int k = 8, m = 2;
        System.out.println("out1 = " + maximumAND(nums, k, m));

        System.out.println("\n");

        nums = new int[] { 1, 2, 8, 4 };
        k = 7;
        m = 3;
        System.out.println("out2 = " + maximumAND(nums, k, m));

        System.out.println("\n");

        nums = new int[] { 82, 55, 96, 50, 71, 83, 45, 69, 32 };
        k = 50;
        m = 4;
        System.out.println("out3 = " + maximumAND(nums, k, m));
    }
}