import java.util.*;

public class SpInBinaryMatrix {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n-1][n-1]!=0) return -1;

        Set<Integer> set = new HashSet<>();

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        int lvl = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (!q.isEmpty()) {
            int t = q.poll();
            int i = t / n - 1, j = t % n - 1;
            map.put(0,1);
            set.add(0);
            for (int k = i; k < i + 3; k++) {
                for (int l = j; l < j + 3; l++) {
                    //System.out.println(k+", "+l);
                    int ind = n * k + l;
                    if (k >= 0 && l >= 0 && k < n && l < n && ind!=t) {
                        int m = grid[k][l];
                        //System.out.println("m= "+m);

                        if (m != 1 && !set.contains(ind)) {
                            set.add(ind);
                            map.put(ind, map.getOrDefault(t,0) + 1);
                            q.add(ind);
                            //System.out.println(map);
                        }

                    }
                }
            }

        }
        Integer getSP = map.get(n * n - 1);
        return getSP == null ? -1 : getSP;
    }

    public static void main(String[] args) {
       int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        //System.out.println(shortestPathBinaryMatrix(grid));
    }
}
