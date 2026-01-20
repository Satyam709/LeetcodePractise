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
            System.out.println("bit = " + i + ", target= " + target);
            PriorityQueue<int[]> pq = new PriorityQueue<>(new comaprator());
            for (int j = 0; j < nums2.length; j++) {
                int opReq = Math.max(0, target - nums2[j]); // if nums[j] > 0 target than the bit is already
                                                            // set take it as zero
                if (pq.size() == m) {
                    int[] polled = pq.poll();
                    System.out.println("size reached polled = " + Arrays.toString(polled));
                }
                pq.add(new int[] { nums2[j], opReq });
            }

            // now lets take and sum the top m
            long sum = 0;
            int[] newAr = new int[m];
            int l = 0;
            while (!pq.isEmpty()) {
                int[] polled = pq.poll();
                sum += polled[1];
                newAr[l++] = polled[0] + polled[1]; // perform the op
                System.out.print(Arrays.toString(polled) + " ");
            }
            System.out.println();

            System.out.println("remOP= "+remOp);
            if (sum <= remOp) {
                System.out.println("found a valid subset! yay!");
                // this subset is possible

                // now we will just look on this
                nums2 = newAr;

                // account this in and
                and |= target;
                System.out.println("crnt and = " + and);

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
            System.out.println("updated NUMS2 = " + Arrays.toString(nums2));
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
    }
}