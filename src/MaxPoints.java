import java.util.ArrayList;
import java.util.HashSet;

public class MaxPoints {
    public long maxPoints(int[][] points) {

        int maxScore = Integer.MIN_VALUE;

        for (int i = 0; i < points[0].length; i++) {
            maxScore = Math.max(maxScore, startAt(points, i));
        }

        return maxScore;
    }

    private int startAt(int[][] points, int at) {
        int score = points[0][at];
        int nc = at;
        for (int i = 1; i < points.length; i++) {
            int[] out = getNextCol(points, i, nc);
            nc = out[0];
            score += out[1];
        }
        return score;
    }

    private int[] getNextCol(int[][] points, int cr, int pc) {
        int cc = -1;
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> dups = new ArrayList<>(3);
        for (int i = 0; i < points[cr].length; i++) {
            int score = points[cr][i] - Math.abs(pc - i);
            if (max < score) {
                cc = i;
                max = score;
                dups.clear();
            }
            else if (max==score) dups.add(i);
        }
        
        return new int[]{cc, max};
    }

    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3}, {1, 5, 1}, {3, 1, 1}};
        int arr2[][] = {{1,5},{2,3},{4,2}};
        int arr3[][] = {{0,0,4,1,4},{2,1,2,0,1},{2,2,1,3,4},{5,2,4,5,4},{0,5,4,2,5}};
        MaxPoints obj = new MaxPoints();
        System.out.println("output = "+obj.maxPoints(arr3));
    }
}
