import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Daily_17_04_2025 {
    public int countPairs(int[] nums, int k) {

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            int finalI = i;
            map.compute(t, (key, val) -> {
                if (val == null) val = new HashSet<>();
                val.add(finalI);
                return val;
            });
        }

        for (Map.Entry<Integer,HashSet<Integer>> e : map.entrySet()){
            HashSet<Integer> set = e.getValue();
            for (int i : set){
                if (set.contains(k/i))count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
    }
}
