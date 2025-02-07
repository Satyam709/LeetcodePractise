import java.util.Arrays;
import java.util.HashMap;

public class Daily_7_02_25 {
    public static int[] queryResults(int limit, int[][] queries) {
        HashMap<Integer, Integer> coloursFreq = new HashMap<>();
        HashMap<Integer,Integer> colorOf = new HashMap<>();
        int ac = 0;

        int[] res = new int[queries.length];
        int t = 0;
        for (int[] i : queries) {
            int x = i[0], y = i[1];
            int prevColor = colorOf.getOrDefault(x,0); // 0 represents no color
            int f = coloursFreq.getOrDefault(prevColor, 0);
            if (f == 1) {
                ac--;
                coloursFreq.remove(prevColor);
            } else
                coloursFreq.put(prevColor, f - 1);

            int g = coloursFreq.getOrDefault(y, 0);
            if (g == 0) ac++;
            coloursFreq.put(y, g + 1);
            colorOf.put(x,y);
            res[t++] = ac;
        }
        return res;
    }

    public static void main(String[] args) {
        int limit = 4;
        int[][] queries = {{1, 4}, {2, 5}, {1, 3}, {3, 4}};
        System.out.println(Arrays.toString(queryResults(limit, queries)));
    }
}
