import edu.princeton.cs.algs4.In;

import java.util.Arrays;

public class MaxChuncksToSort {
    public static int maxChunksToSorted(int[] arr) {
        int chuncks  = 0 ;
        int[] l_max = new int[arr.length];
        int[] r_min = new int[arr.length];

        l_max[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            l_max[i] = Math.max(l_max[i-1],arr[i]);
        }
        r_min[arr.length-1] = Integer.MAX_VALUE;
        for (int i = arr.length-2; i>=0; i--) {
            r_min[i] = Math.min(r_min[i+1],arr[i+1]);
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(l_max));
        System.out.println(Arrays.toString(r_min));

        for (int i = 0; i < arr.length; i++) {
            if (l_max[i] <= r_min[i])chuncks++;
        }
        return chuncks;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 4};
        int[] arr2 = {4,3,2,1,0};
        System.out.println("out = "+maxChunksToSorted(arr));
        System.out.println("out = "+maxChunksToSorted(arr2));
    }
}
