import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class KthLargest {
    private List<Integer> nums;
    private final int target;

    public KthLargest(int k, int[] nums) {
        this.nums = new LinkedList<>();
        for (int num : nums) {
            this.nums.add(num);
        }
        Collections.sort(this.nums);
        this.target = k;
    }

    public int add(int val) {
        int index=1;
        for (int i :nums){
            if (val<=i){
                break;
            }
            index++;
        }
        nums.add(index-1,val);
        System.out.println("size" + nums.size());
        return nums.get(nums.size()-target);
    }

    public static void main(String[] args) {

    }
}
