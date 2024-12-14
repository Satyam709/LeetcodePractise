import java.util.Collections;
import java.util.PriorityQueue;

public class ContinuousCustomSubarray {
    public static long continuousSubarrays(int[] nums) {

        int l = 0, r;

        int max = 0;
        int min = 0;

        PriorityQueue<Integer> minpq = new PriorityQueue<>(nums.length);
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(nums.length, Collections.reverseOrder());

        minpq.add(nums[0]);
        maxpq.add(nums[0]);

        long count = 0;

        for (r = 1; r < nums.length; r++) {
            max = maxpq.peek();
            min = minpq.peek();

            System.out.println("maxpq = " + maxpq);
            System.out.println("minpq = " + minpq);

            int crnt = nums[r];

            System.out.println("crnt = " + crnt);

            while (l<r && (Math.abs(crnt - maxpq.peek()) > 2 || Math.abs(crnt - minpq.peek()) > 2)) {
                System.out.println(crnt + " is invalid ! \n counting ..");
                System.out.println("increment of = " + (r - l));
                count += r - l - 1;
                System.out.println("final count = " + count);
                maxpq.remove(nums[l]);
                minpq.remove(nums[l]);
                System.out.println("removed " + nums[l]);
                l++;
            }
            maxpq.add(crnt);
            minpq.add(crnt);
        }
        System.out.println("increment of = " + ((long) (r - l) * (r - l - 1) / 2));
        count += (long) (r - l) * (r - l - 1) / 2;

        count += nums.length;

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {5, 25};
        System.out.println("out = " + continuousSubarrays(nums));
    }
}
