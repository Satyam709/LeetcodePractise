import java.util.Arrays;

public class DisconnectedIslands {
    private int minDays;

    public int minDays(int[][] grid) {
        // Reset minDays for each test case
        minDays = 0;

        int r = grid.length;
        int c = grid[0].length;

        if (countIslands(grid) > 1) {
            return 0; // Already disconnected
        }

        // Try removing one land cell and check if it disconnects the grid
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0; // Remove land
                    if (countIslands(grid) > 1) {
                        return 1; // Disconnected with one removal
                    }
                    grid[i][j] = 1; // Restore land
                }
            }
        }

        // If it cannot be disconnected by removing one land cell, return 2
        return 2;
    }

    private int countIslands(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        int count = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i, j - 1);
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1}};
        DisconnectedIslands obj = new DisconnectedIslands();
        System.out.println("Min days = " + obj.minDays(grid));
    }
}
