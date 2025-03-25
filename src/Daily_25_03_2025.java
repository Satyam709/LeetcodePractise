import java.util.Arrays;
import java.util.Comparator;

public class Daily_25_03_2025 {
    public static boolean checkValidCuts(int n, int[][] rectangles) {
        return checkX(rectangles) || checkY(rectangles);
    }
    private static boolean checkX(int[][] reac){
        int n = reac.length;
        int[][] x = new int[n][2];

        for (int i = 0; i < n; i++) {
            x[i][0] = reac[i][0];
            x[i][1] = reac[i][2];
        }
        Arrays.sort(x, Comparator.comparingInt(a->a[0]));
        int r = x[0][1] ,count = 0;
        for (int i = 1; i < n; i++) {
            int[] current = x[i];
            if (current[0]>=r){
                count++;
            }
            r= Math.max(r,current[1]);
            if (count>=2)return true;
        }
        return false;
    }

    private static boolean checkY(int[][] reac){
        int n = reac.length;
        int[][] y = new int[n][2];

        for (int i = 0; i < n; i++) {
            y[i][0] = reac[i][1];
            y[i][1] = reac[i][3];
        }
        Arrays.sort(y, Comparator.comparingInt(a->a[0]));
        int up = y[0][1] ,count = 0;
        for (int i = 1; i < n; i++) {
            int[] current = y[i];
            if (current[0]>=up){
                count++;
            }
            up= Math.max(up,current[1]);
            if (count>=2)return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] reac = {{1,0,5,2},{0,2,2,4},{3,2,5,3},{0,4,4,5}};
        int n = 5;
        System.out.println(checkValidCuts(n,reac));
    }
}
