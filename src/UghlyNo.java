import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UghlyNo {

    private List<Integer> primes;

    public int nthUglyNumber(int n) {
        int k =1;
        int c =0;
        while (c<n){
            while (!check(k)) {
               // System.out.println("not ->" + k);
                k++;
            };

            c++;
            if (c==n)return k;
            k++;
        }
        return k;
    }

    private boolean check(int n){
        while (n%2==0)n/=2;
        while (n%3==0)n/=3;
        while (n%5==0)n/=5;

        return n == 1;
    }


    private void createPrimes(int n) {
        boolean[] sieve = new boolean[n + 1];
        Arrays.fill(sieve, true);

        primes = new ArrayList<>((int) Math.sqrt(n));

        for (int i = 2; i * i <= n; i++) {

            if (!sieve[i])
                continue;

            for (int j = i * i; j <= n; j += i) {
                sieve[j] = false;
            }
        }

        for (int i = 2; i < sieve.length; i++) {
            if (sieve[i])
                primes.add(i);
        }
    }

    public static void main(String[] args) {
        int s = 10;

        UghlyNo obj = new UghlyNo();
        System.out.println(obj.nthUglyNumber(s));
    }
}
