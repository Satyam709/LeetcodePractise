import java.util.Arrays;

public class Daily_13_01_25 {
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] freqA = new int[10];
        int[] freqB = new int[10];

        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            freqA[A[i]]++;
            freqB[B[i]]++;

            int sum = 0;
            for (int j = 0; j <= 9; j++) {
                sum+=Math.min(freqA[j],freqB[j]) == 0 ? 0:1;
            }
            res[i] =sum;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {1,3,2,4}, B = {3,1,2,4};
        System.out.println(Arrays.toString(findThePrefixCommonArray(A, B)));
    }
}
