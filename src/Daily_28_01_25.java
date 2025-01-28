public class Daily_28_01_25 {
    public static int findMaxFish(int[][] grid) {
        int max = 0;
        int m = grid.length;
        ;
        int n = grid[0].length;
        int[] nr = {1, -1, 0, 0};
        int[] nc = {0, 0, -1, 1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    max = Math.max(max, dfs(grid, i, j, nr, nc));
                }
            }
        }
        return max;
    }

    private static int dfs(int[][] grid, int i, int j, int[] nr, int[] nc) {
        if (grid[i][j] == 0) return 0;
        int sum = grid[i][j];
        grid[i][j] = 0;
        for (int k = 0; k < nc.length; k++) {
            int i2 = i + nr[k];
            int j2 = j + nc[k];
            if (i2 < 0 || i2 >= grid.length || j2 < 0 || j2 >= grid[0].length) continue;
            sum += dfs(grid, i2, j2, nr, nc);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 2, 1, 0}, {4, 0, 0, 3}, {1, 0, 0, 4}, {0, 3, 2, 0}};
        System.out.println("out = " + findMaxFish(grid));
    }
}
