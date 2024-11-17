import java.util.*;

public class MinSubArrSumAtleastK {

//    static class Pair implements Comparable<Pair> {
//        public final int s;
//        public final int idx;
//
//        Pair(int s, int idx) {
//            this.idx = idx;
//            this.s = s;
//        }
//
//
//        @Override
//        public String toString() {
//            return " (" + s + "," + idx + ") ";
//        }
//
//        @Override
//        public int compareTo(Pair o) {
//            if (this.s == o.s)
//                return this.idx - o.idx;
//            return this.s - o.s;
//        }
//    }

    public static int shortestSubarray(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int sum = 0, min = nums.length + 1;
        boolean gotSome = false;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            System.out.println("crnt sum " + sum);
            if (sum >= k) min = Math.min(min, i + 1);

            int out = getMaxValidIdx(map, sum - k, k);
            if (out != -1)
                min = Math.min(min, i - out);
            Integer t = map.getOrDefault(sum,-1);
            if (i>t)map.put(sum,i);


            System.out.println("min after " + i + " is " + min);
        }
        return min > nums.length ? -1 : min;
    }

    private static int getMaxValidIdx(TreeMap<Integer, Integer> map, int sum, int k) {
        if (map.isEmpty()) return -1;
        int res = -1;

        System.out.println("called for <= " + sum);
        System.out.println("crnt pq -> " + map);


        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer top = entry.getValue();
            assert top != null;
            if (entry.getKey() > sum)
                break;
            res = Math.max(res, top);
        }

        System.out.println("returning " + res);
        return res;
    }

    public static void main(String[] args) {

        int[] nums = {2, -1, 2};
        int k = 3;
        int[] nums2 = {1, 2};
        int k2 = 4;
        int[] nums3 = {1};
        int k3 = 1;
        int[] nums4 = {17, 85, 93, -45, -21};
        int k4 = 150;

//        System.out.println("output1 = " + shortestSubarray(nums, k));
//        System.out.println("output2 = " + shortestSubarray(nums2, k2));
//        System.out.println("output3 = " + shortestSubarray(nums3, k3));

        int[] nums5 = {-34, 37, 51, 3, -12, -50, 51, 100, -47, 99, 34, 14, -13, 89, 31, -14, -44, 23, -38, 6};
        int k5 = 151;
        System.out.println("output4 = " + shortestSubarray(nums5, k5));
    }
}
