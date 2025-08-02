import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Daily_02_08_2025 {
    public static long minCost(int[] basket1, int[] basket2) {
        int n = basket1.length;
        HashMap<Integer, Integer> freq1 = new HashMap<>();
        HashMap<Integer, Integer> freq2 = new HashMap<>();

        Set<Integer> set = new HashSet<>();
        Set<Integer> setExcess = new HashSet<>();
        for (int i : basket1) {
            freq1.put(i, freq1.getOrDefault(i, 0) + 1);
            set.add(i);
        }
        for (int i : basket2) {
            freq2.put(i, freq2.getOrDefault(i, 0) + 1);
            set.add(i);
        }
        int min = Integer.MAX_VALUE;
        int td = 0;
        int eq = 0;
        int el = 0;

        for (int i : set) {
            int diff = freq1.getOrDefault(i, 0) - freq2.getOrDefault(i, 0);
            min = Math.min(min, i);
            td += diff;
            if (diff % 2 != 0) return -1;
            if (diff == 0) {
                freq1.remove(i);
                freq2.remove(i);
                eq++;
            }else if (diff>0){
                el += diff/2;
            }
        }
        if (td != 0) return -1;

        int[] exs1 = new int[el];
        int[] exs2 = new int[el];

        int e1 = 0, e2 = 0;
        for (int i : set) {
            int diff = (freq1.getOrDefault(i, 0) - freq2.getOrDefault(i, 0)) / 2;
            while (diff> 0) {
                exs1[e1++] = i;
                diff--;
            }
            while (diff < 0) {
                exs2[e2++] = i;
                diff++;
            }
        }

        Arrays.sort(exs1);
        Arrays.sort(exs2);
        System.out.println(Arrays.toString(exs1));
        System.out.println(Arrays.toString(exs2));
        long cost = 0;
        e1 = el - 1;
        e2 = 0;
        while (el > 0) {
            int max1 = exs1[e1--];
            int max2 = exs2[e2++];
            cost += Math.min(Math.min(max2,max1), 2 * min);
            el--;
        }
        return cost;
    }

    public static void main(String[] args) {
        int[] basket1 = {4, 2, 2, 2}, basket2 = {1, 4, 1, 2};

        System.out.println(minCost(basket1, basket2));
    }
}
