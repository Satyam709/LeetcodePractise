import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class CountSelfSmaller {
    public List<Integer> countSmaller(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        return null;
    }

    public static void main(String[] args) {
        int[] a = {5,2,6,1};
        CountSelfSmaller obj = new CountSelfSmaller();
        obj.countSmaller(a);
    }
}
