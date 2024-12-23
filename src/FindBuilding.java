import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class FindBuilding {
    public static int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[] qres = new int[heights.length];
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();

        for (int i = 0; i < heights.length; i++) {
            TreeSet<Integer> val = map.getOrDefault(heights[i], new TreeSet<>());
            val.add(i);
            map.put(heights[i], val);
        }
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            Map.Entry<Integer, TreeSet<Integer>> ent = map.ceilingEntry(Math.max(heights[a], heights[b]) + 1);
            System.out.println(ent);
            qres[i] = ent == null ? -1 : ent.getValue().ceiling(Math.max(a, b));
        }
        return qres;
    }

    public static int[] leftmostBuildingQueries2(int[] heights, int[][] queries) {
        int[] qres = new int[queries.length];
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < heights.length; i++) {
            int val = map.getOrDefault(heights[i], i);
            map.put(heights[i], Math.min(val, i));
        }
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];

            int idx = Math.max(a, b);

            int hmax = a;
            if (heights[hmax] < heights[b]){
                hmax =b;
            }
            if (a == b || (heights[a] != heights[b] && hmax == idx)){
                qres[i] = idx;
                continue;
            }
            int h = heights[hmax];

            int got = -1;
            for (int j = idx + 1; j < heights.length; j++) {
                if (heights[j] > h) {
                    got = j;
                    break;
                }
            }
            qres[i] = got;
        }
        return qres;
    }

    public static void main(String[] args) {
        int[] heights = {6, 4, 8, 5, 2, 7};
        int[][] queries = {{0, 1}, {0, 3}, {2, 4}, {3, 4}, {2, 2}};

        System.out.println("out " + Arrays.toString(leftmostBuildingQueries2(heights, queries)));
    }
}
