import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxDistInArr {
    public int maxDistance(List<List<Integer>> arrays) {
        int maxDis = 0;

        int[][] array = new int[arrays.size()][];
        int i = 0;
        for (List<Integer> subarr : arrays) {
            array[i] = new int[subarr.size()];
            int j = 0;
            for (int t : subarr) {
                array[i][j++] = t;
            }
            i++;
        }

        int sm=-1, lg=-1, smNext=-1, lgNext=-1;

        int smE = Integer.MAX_VALUE, smNe = Integer.MAX_VALUE, lgE = Integer.MIN_VALUE, lgNe = Integer.MIN_VALUE;

        for (int j = 0; j < array.length; j++) {

            if (smE > array[j][0]) {
                smNe = smE;
                smE = array[j][0];

                smNext = sm;
                sm = j;
            } else if (smNe > array[j][0]) {
                smNe = array[j][0];
                smNext = j;
            }

            if (lgE < array[j][array[j].length - 1]) {
                lgNe = lgE;
                lgE = array[j][array[j].length - 1];

                lgNext = lg;
                lg = j;
            } else if (lgNe < array[j][array[j].length - 1]) {
                lgNe = array[j][array[j].length - 1];
                lgNext = j;
            }
        }
        System.out.println(smNext);
        System.out.println(lgNext);
        System.out.println(sm);
        System.out.println(lg);
        System.out.println(array[lgNext][array[lgNext].length - 1] - array[smNext][0]);

        if (sm != lg) {
            return Math.abs(array[lg][array[lg].length - 1] - array[sm][0]);
        }


        int diffSm = Math.abs(array[sm][0] - array[smNext][0]); // 0
        int diffLg = Math.abs(array[lg][array[lg].length - 1] - array[lgNext][array[lgNext].length - 1]);

        System.out.println("diffSm " + diffSm);
        System.out.println("diffLg " + diffLg);
        if (diffLg < diffSm) {
            if (array[sm][0] > array[smNext][0]) {
                sm = smNext;
            } else {
                lg = lgNext;
            }
        } else if (diffLg > diffSm) {

            if (array[lg][array[lg].length - 1] < array[lgNext][array[lgNext].length - 1]) {
                lg = lgNext;
            } else {
                sm = smNext;
            }

        } else {
            lg = lgNext;
        }

        System.out.println("final sm = " + sm);
        System.out.println("final lg = " + lg);

        System.out.println(Arrays.deepToString(array));
        System.out.println(sm + "\t" + lg);
        return Math.abs(array[lg][array[lg].length - 1] - array[sm][0]);
    }

    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();

        // Add each sublist
        arr.add(Arrays.asList(1, 5));
        arr.add(Arrays.asList(3, 4));
        //arr.add(Arrays.asList(-2, -1, 0, 2));

//        arr.add(Arrays.asList(1));
//        arr.add(Arrays.asList(1));
        MaxDistInArr obj = new MaxDistInArr();
        System.out.println(obj.maxDistance(arr));

    }
}
