public class Daily_12_04_2025 {

    private static long[] factorial;


    public static long countGoodIntegers(int n, int k) {
        int digits = (int) Math.ceil(n / 2.0) - 1;
        long start = (long) Math.pow(10, digits);
        long end = (long) Math.pow(10, digits + 1) - 1;


        factorial = new long[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }


        long count = 0;
        if ((n & 1) == 0) {
            for (long i = start; i < end; i++) {
                StringBuilder rev = new StringBuilder("" + i).reverse();
                String fv = "" + i + rev;
                int finalVal = Integer.parseInt(fv);
                if (finalVal % k == 0) {
                    count+= validatePermutations(fv);
                }
            }
        } else {
            for (long i = start; i < end; i++) {
                StringBuilder rev = new StringBuilder("" + i).reverse();
                String fv = i + rev.substring(1);
                int finalVal = Integer.parseInt(fv);
                if (finalVal % k == 0) {
                    count+= validatePermutations(fv);
                }
            }
        }
        return count;
    }

    private static long validatePermutations(String s) {
        int n = s.length();
        int[] cnt = new int[10];
        for (char ch : s.toCharArray()) {
            cnt[ch - '0']++;
        }
        /* Calculate permutations and combinations */
        long tot = (n - cnt[0]) * factorial[n - 1];
        for (int x : cnt) {
            tot /= factorial[x];
        }
        return tot;
    }

    public static void main(String[] args) {
        System.out.println(countGoodIntegers(3, 5));
    }
}
