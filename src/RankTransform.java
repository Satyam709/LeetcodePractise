import java.util.Arrays;
import java.util.HashMap;

public class RankTransform {
    public static int[] arrayRankTransform(int[] arr) {
        int[] tmp = Arrays.copyOf(arr,arr.length);
        sort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(tmp));
        HashMap<Integer,Integer> map = new HashMap<>(arr.length);
        int count = 1;
        for (int j : arr) {
            if (!map.containsKey(j))
                map.put(j, count++);
        }
        for (int i = 0; i < arr.length; i++)
            tmp[i] = map.get(tmp[i]);
        return tmp;
    }

    private static void sort(int[] arr, int lw, int up) {
        if (up <= lw) return;
        int lt = lw, i = lt + 1, gt = up;
        while (i <= gt) {
            int cmp = arr[i] - arr[lt];
            if (cmp == 0) i++;
            else if (cmp > 0) swap(arr, i, gt--);
            else swap(arr, lt++, i++);
        }

        sort(arr, lw, lt - 1);
        sort(arr, i, up);
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {37,12,28,9,100,56,80,5,12};
        System.out.println(Arrays.toString(arrayRankTransform(arr)));
    }

}
