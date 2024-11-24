import edu.princeton.cs.algs4.BST;

import java.util.Arrays;

public class ZeroOneKnapsack {
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        /* Your class should be named Solution
         * Don't write main().
         * Don't read input, it is passed as function argument.
         * Change in the given tree itself.
         * No need to return or print the output.
         * Taking input and printing output is handled automatically.
         */

        int[] prev = new int[maxWeight + 1];
        for (int i = 0; i <= maxWeight; i++) {
            if (weight[0] <= i) {
                prev[i] = value[0];
            }
        }

        for (int i = 1; i < value.length; i++) {
            System.out.println(Arrays.toString(prev));
            int[] crnt = new int[maxWeight + 1];
            for (int j = 0; j <= maxWeight; j++) {
                crnt[j] = Math.max(j - weight[i] >= 0 ? value[i] + prev[j - weight[i]] : 0, prev[j]);
            }
            prev = crnt;
        }

        System.out.println(Arrays.toString(prev));

        return prev[maxWeight];
    }
}
