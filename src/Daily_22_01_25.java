import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Daily_22_01_25 {
    public static int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] island = new int[m][n];

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                island[i][j] = -1;
                if (isWater[i][j] == 1) {
                    q.add(new int[]{i, j});
                    island[i][j] = 0;
                }
            }

        }
        while (!q.isEmpty()) {
            int[] top = q.poll();
            int i = top[0], j = top[1];
            // up
            int i1 = island[i][j];

            if (i>0 && island[i-1][j]==-1)
            {
                island[i-1][j] = i1 +1;

                q.add(new int[]{i-1,j});
            }
            // down
            if (i<m-1 && island[i+1][j]==-1)
            {
                island[i+1][j] = i1 +1;
                q.add(new int[]{i+1,j});
            }
            // left
            if (j>0 && island[i][j-1]==-1)
            {
                island[i][j-1] = i1 +1;
                q.add(new int[]{i,j-1});
            }
            // right
            if (j<n-1 && island[i][j+1]==-1)
            {
                island[i][j+1] = i1 +1;
                q.add(new int[]{i,j+1});
            }
        }
        return island;
    }

    public static void main(String[] args) {
        int[][] isWater = {{0,0,1},{1,0,0},{0,0,0}};
        System.out.println(Arrays.deepToString(highestPeak(isWater)));
    }
}
