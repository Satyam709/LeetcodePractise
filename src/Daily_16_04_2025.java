import java.util.HashMap;
import java.util.Map;

public class Daily_16_04_2025 {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> mpp = new HashMap<>();
        long cnt = 0;
        int left = 0;
        for (int num : nums) {
            k -= mpp.getOrDefault(num, 0);
            mpp.put(num, mpp.getOrDefault(num, 0) + 1);
            while (k <= 0) {
                mpp.put(nums[left], mpp.get(nums[left]) - 1);
                k += mpp.get(nums[left++]);
            }
            cnt += left;
        }
        return cnt;
    }


    public static void main(String[] args) {

    }
}
