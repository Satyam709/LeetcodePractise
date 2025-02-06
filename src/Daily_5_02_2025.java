import java.util.HashMap;
import java.util.Map;

public class Daily_5_02_2025 {

    public static int tupleSameProduct(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int prod = arr[i] * arr[j];
                map.compute(prod, (key, val) -> {
                    if (val == null) return 1;
                    return val + 1;
                });
            }
        }

        long ans = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            long combos = ((long) e.getValue() * (e.getValue() - 1)) * 2 * 2;
            ans += combos;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 10};
        System.out.println(tupleSameProduct(nums));
    }
}
