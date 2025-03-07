import java.util.Arrays;

public class Daily_07_03_2025 {
    static class PrimeSieve {
        public final boolean[] sieve;
        public final int size;

        PrimeSieve(int n) {
            sieve = new boolean[n + 1];
            size = n;
            fillSieve();
        }

        private void fillSieve() {
            for (int i = 2; i < size; i++) {
                if (sieve[i])
                    continue;
                for (int j = 2 * i; j < size; j += i) {
                    sieve[j] = true;
                }
            }
        }

        public boolean isPrime(int n) {
            if (n > size + 1) throw new IllegalArgumentException();
            return !sieve[n];
        }
    }

    public static int[] closestPrimes(int left, int right) {
        PrimeSieve ps = new PrimeSieve(right + 1);
        int first = -1, second = -1, last = -1, diff = Integer.MAX_VALUE;

//        for (int i = left; i <= right; i++) {
//            if (ps.isPrime(i)) System.out.print(i + " ");
//        }
//        System.out.println();
        for (; left <= right; left++) {
            if (!ps.isPrime(left)) continue;
            if (last != -1) {
                if (left - last < diff) {
                    first = last;
                    second = left;
                    diff = second - first;
                }
            }
            last = left;
        }
        if (second == -1) first = -1;
        return new int[]{first, second};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(closestPrimes(19, 31)));
    }
}
