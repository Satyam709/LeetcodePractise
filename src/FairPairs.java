import java.util.Arrays;
import java.util.Comparator;

public class FairPairs {
    public static long countFairPairs(int[] nums, int lower, int upper) {
        long pairs = 0;

        Integer[] arr = new Integer[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = i;
        }

        Arrays.sort(arr, Comparator.comparingInt(i -> nums[i]));
        System.out.println("Array -> " + Arrays.toString(arr));


//        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            int finalI = i;
//            map.compute(nums[i], (key, val)->{
//                List<Integer> li = val;
//                if (val == null)
//                    li = new ArrayList<>();
//                li.add(finalI);
//                return li;
//            });
//        }
//
//
//        List<Integer> lw = map.ceilingEntry(lower).getValue();
//        List<Integer> upw = map.floorEntry(upper).getValue();


        for (int i = 0; i < nums.length; i++) {
            int t = 0;
            System.out.println("checking for " + nums[arr[i]]);
            int lw_lmt = lower - nums[arr[i]];
            int up_lmt = upper - nums[arr[i]];

            if (lw_lmt<0|| up_lmt<0)break;

            int lw = getCeil(nums, arr, lw_lmt);
            int up = getFloor(nums, arr, up_lmt);

            System.out.println("lower index got = " + lw);
            System.out.println("upper index got = " + up);
            if (lw == -1 || up == -1)continue;
            for (; lw <= up; lw++) {
                if (arr[lw] > i) {
                    System.out.println("pair " + t + " => (" + i + "," + arr[lw] + ")");
                    t++;
                }
            }


            System.out.println("pairs for " + nums[arr[i]] + " -> " + t);
            pairs += t;
            System.out.println();
        }


        return pairs;
    }

    private static int getFloor(int[] nums, Integer[] arr, int k) {
        int lw = 0, up = nums.length - 1;
        int lastGot = -1;
        while (lw <= up) {
            int mid = lw + (up - lw) / 2;
            if (nums[arr[mid]] > k) {
                up = mid - 1;
            } else {
                lastGot = mid;
                lw = mid + 1;
            }
        }
        return lastGot;
    }

    private static int getCeil(int[] nums, Integer[] arr, int k) {
        int lw = 0, up = nums.length - 1;
        int lastGot = -1;
        while (lw <= up) {
            int mid = lw + (up - lw) / 2;
            if (nums[arr[mid]] < k) {
                lw = mid + 1;
            } else {
                lastGot = mid;
                up = mid - 1;
            }
        }
        return lastGot;
    }

    public static void main(String[] args) {
//        int[] nums = {0, 1, 7, 4, 4, 5};
//        int lower = 3, upper = 6;


        int[] nums = {1, 7, 9, 2, 5}; int lower = 11, upper = 11;
        System.out.println(countFairPairs(nums, lower, upper));
    }
    }
