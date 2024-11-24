import edu.princeton.cs.algs4.BST;

import java.util.List;

public class TriangleDp {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][];

        dp[0] = new int[]{triangle.getFirst().getFirst()};

        int min = Integer.MAX_VALUE;

        int i = 0, j = 0;
        for (List<Integer> li : triangle) {
            j=0;
            for (int lj : li) {
                if (i == 0) {
                    j++;
                    continue;
                };
                dp[i] = new int[i + 1];
                int up = Integer.MAX_VALUE, left = up;
                if (j <= i-1)
                    up = dp[i - 1][j];
                if (j-1>=0)
                    left = dp[i-1][j];

                dp[i][j] =lj + Math.min(left,up);
                if (i == triangle.size()-1){
                    min = Math.min(dp[i][j],min);
                }
                j++;
            }
            i++;

        }


        return min;
    }

    public static void main(String[] args) {
    }
}
