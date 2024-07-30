import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;

public class FreqSort {
    public int[] frequencySort(int[] nums) {
        int[] freq = new int[10];


        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.get(num) == null) {
                map.put(num, 1);
            } else map.put(num, map.get(num) + 1);
        }
        int countUnique = map.size();
        Freq[] dataFreq = new Freq[countUnique];
        int k = 0;
        for (int i : map.keySet()) {
            dataFreq[k++] = new Freq(i, map.get(i));
        }

        Arrays.sort(dataFreq);
        k = 0;
        for (int i = 0; i < countUnique; i++) {
            for (int j = 0; j < dataFreq[i].freq; j++) {
                nums[k++] = dataFreq[i].data;
            }
        }
        return nums;
    }

    private record Freq(int data, int freq) implements Comparable<Freq> {

        @Override
        public int compareTo(Freq o) {
            return Integer.compare(this.freq, o.freq);
        }

        @Override
        public int hashCode() {
            return this.data;
        }
    }

    public static void main(String[] args) {
        Hashtable<Integer,Integer> fg = new Hashtable<>();
    }
}
