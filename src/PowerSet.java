
import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static List<List<Integer>> subsets(int[] nums) {
        int total = 1 << nums.length;
        List<List<Integer>> out = new ArrayList<>(total);
        System.out.println(4 & 5);
        for (int i = 0; i < total; i++) {

            List<Integer> lt = new ArrayList<>(nums.length);

            for (int j = 0; j < nums.length; j++) {
                int d = i & (1 << j);
                System.out.println(d);
                if (d != 0) {
                    lt.add(nums[j]);
                }
            }
            out.add(lt);
        }
        return out;
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }
}
