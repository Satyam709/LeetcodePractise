import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArrayBySubPrime {

    public static boolean primeSubOperation(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int[] primes = getPrimesTill(max);
        System.out.println("Primes up to max: " + Arrays.toString(primes));

        for (int i = nums.length - 1; i > 0; i--) {
            int prime = getNearestPrime(primes, nums[i], nums[i - 1]);
            if (prime > 0) {
                nums[i] -= prime;
                if (nums[i] > nums[i - 1]) {
                    continue;
                } else {
                    prime = getNearestPrime(primes, nums[i - 1], nums[i]);
                    if (prime > 0) {
                        nums[i - 1] -= prime;
                    }
                }
            }
            System.out.println(Arrays.toString(nums));
            if (nums[i] <= nums[i - 1]) {
                return false; // Not sorted in increasing order
            }
        }

        return true;
    }

    private static int getNearestPrime(int[] primes, int target, int limit) {
        int nearestPrime = 0;
        for (int prime : primes) {
            if (prime < target && prime > limit) {
                nearestPrime = prime;
            } else if (prime >= target) {
                break;
            }
        }
        return nearestPrime;
    }

    private static void createSieve(boolean[] arr) {
        Arrays.fill(arr, true);
        arr[0] = arr[1] = false;
        for (int i = 2; i * i < arr.length; i++) {
            if (arr[i]) {
                for (int j = i * i; j < arr.length; j += i) {
                    arr[j] = false;
                }
            }
        }
    }

    private static int[] getPrimesTill(int n) {
        boolean[] sieve = new boolean[n + 1];
        createSieve(sieve);
        List<Integer> primesList = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (sieve[i]) {
                primesList.add(i);
            }
        }
        return primesList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {4, 9, 6, 3};
        System.out.println("Is array sorted after operations? " + primeSubOperation(arr));
    }
}