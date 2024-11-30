import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinTimeToVisitACellInGrid {
//    public static int minimumTime(int[][] grid) {
//
//        int m = grid.length;
//        int n = grid[0].length;
//
//        Queue<int[][]> q = new LinkedList<>();
//        //format : current node,time
//        q.add(new int[][]{{0, 0}, {0}});
//        int[][] distTo = new int[m][n];
//
//        for (int[] i : distTo) Arrays.fill(i, -1);
//
//        boolean[][] visited = new boolean[m][n];
//
//        int[][] neighbours = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//
//        while (!q.isEmpty()) {
//            int[][] polled = q.poll();
//            int[] crnt = polled[0];
//            int time = polled[1][0];
//            int i = crnt[0], j = crnt[1];
//
////            if (visited[i][j]) continue;
//            if (distTo[i][j] == -1)
//                distTo[i][j] = time;
//
//            if (i == m - 1 && j == n - 1) break;
//
//            // visit neighbours
//            int count = 0;
//            time++;
//            for (int[] nei : neighbours) {
//                int k = i + nei[0], l = j + nei[1];
//
//                if (isValid(k, l, m, n) && time>=grid[k][l]) {
//                  //  count++;
////                    if (!visited[k][l])
//                    q.add(new int[][]{{k, l}, {time}});
//                }
//            }
////            if (count == 4) visited[i][j] = true;
//        }
//        return distTo[m - 1][n - 1];
//    }

    public static int minimumTime(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        PriorityQueue<int[][]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1][0]));
        //format : current node,time
        pq.add(new int[][]{{0, 0}, {0}});
        int[][] distTo = new int[m][n];

        for (int[] i : distTo) Arrays.fill(i, Integer.MAX_VALUE);

        boolean[][] visited = new boolean[m][n];

        int[][] neighbours = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!pq.isEmpty()) {
            int[][] polled = pq.poll();

            int[] crnt = polled[0];
            System.out.println("crnt -> "+ Arrays.deepToString(polled));
            int time = polled[1][0];
            int i = crnt[0], j = crnt[1];

            if (visited[i][j]) continue;
            visited[i][j] =true;

            if (i == m - 1 && j == n - 1) return distTo[i][j];

            // visit neighbours
            for (int[] nei : neighbours) {
                int k = i + nei[0], l = j + nei[1];
                if (isValid(k, l, m, n) && !visited[k][l]) {

                    int assignTime = time+1;

                    System.out.println(assignTime);
                    System.out.println("visiting "+grid[k][l]);

                    if (assignTime<grid[k][l]) {
                        int diff = grid[k][l] - time;
                        assignTime = grid[k][l] + (diff%2==0?1:0);
                        System.out.println(assignTime);
                    }

                    if (assignTime < distTo[k][l]) {
                        distTo[k][l] = assignTime;
                        pq.add(new int[][]{{k, l}, {assignTime}});
                    }

                    System.out.println("assigned to k="+k+" l="+l+" => "+assignTime);

                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1, 3, 2}, {5, 1, 2, 5}, {4, 3, 8, 6}};

        int[][] grid2 = {{0, 2, 4}, {3, 2, 1}, {1, 0, 4}};
        System.out.println("out = " + minimumTime(grid));
        System.out.println("out = " + minimumTime(grid2));
    }

    private static boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
