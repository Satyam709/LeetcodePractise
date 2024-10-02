import java.util.HashMap;

public class PairsByK {

    public boolean canArrange(int[] arr, int k) {

        HashMap<Integer, Integer> freq = new HashMap<>();

        int count = 0;

        for (int i : arr) {

            int rem = i % k;

            if (rem < 0) rem += k;

            int alt = k - rem;

            if (alt == k) alt = 0;

            Integer tmp2 = freq.get(alt);

            if (tmp2 != null && tmp2 > 0) {
                count++;
                freq.put(alt, tmp2 - 1);
            } else {
                freq.merge(rem, 1, Integer::sum);
            }
        }
        return count == arr.length / 2;
    }

    public boolean canArrange2(int[] arr, int k) {
        int[] freq = new int[k];
        int count = 0, rem, alt;

        for (int i : arr) {
            rem = ((i % k) + k) % k;

            alt = k - rem;
            if (alt == k) alt = 0;

            if (freq[alt] > 0) {
                count++;
                freq[alt]--;
            } else
                freq[rem]++;
        }
        return count == arr.length / 2;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
        int k = 5;

        PairsByK obj = new PairsByK();
        System.out.println("output = " + obj.canArrange(arr, k));
    }

}
