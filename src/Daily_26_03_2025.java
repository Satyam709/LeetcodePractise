import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Daily_26_03_2025 {
    public static int minOperations(int[][] grid, int x) {

        List<Integer> values = new ArrayList<>();

        for (int[] row : grid) {
            for (int val : row) {
                values.add(val);
            }
        }

        Collections.sort(values);

        for (int val : values) {
            if (Math.abs(val - values.getFirst()) % x != 0) {
                return -1;
            }
        }

        int median = values.get(values.size() / 2);
        int operations = 0;

        for (int val : values) {
            operations += Math.abs(val - median) / x;
        }

        return operations;

    }

    public static void main(String[] args) {
        int[][] grid = {{2, 4}, {6, 8}};
        int x = 2;
        System.out.println(minOperations(grid, x));
    }
}
