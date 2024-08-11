import java.util.Arrays;

public class DisconnectedIslands {
    private int totalEdges =0;
    private int minDays=0;
    public int minDays(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;

        int[][] graph = new int[r][c];
//        int[][] marked = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int edges = 1;
                if (!isIsland(grid, i, j)) {
//                    marked[i][j] = -2; // not a island
                    continue;
                }
                if (isEdge(grid, i + 1, j)) {
                    edges++;
                }
                if (isEdge(grid, i - 1, j)) {
                    edges++;
                }
                if (isEdge(grid, i, j + 1)) {
                    edges++;
                }
                if (isEdge(grid, i, j - 1)) {
                    edges++;
                }
                graph[i][j] = edges;
                totalEdges+=edges;
            }
        }
        return findMinDays(graph);
    }


    private int findMinDays(int[][] graph) {
        // go dfs
        System.out.println("total edges = "+totalEdges);
        while (true){
            int r = graph.length;
            int c = graph[0].length;
            int totalComponents = 0;
            int[][] marked = new int[graph.length][graph[0].length];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (isIsland(graph, i, j) && marked[i][j] >= 0) {
                        int[] maxEdgeIndex = new int[]{i, j};
                        dfs_operate(graph, marked, i, j, maxEdgeIndex);
                        totalComponents++;
                        fillWater(graph, maxEdgeIndex[0], maxEdgeIndex[1]);
                    }
                }
            }
            System.out.println("Connected Components = " + totalComponents);
            System.out.println("Graph generated :");
            printMat(graph);

            System.out.println("Marked generated :");
            printMat(marked);
            System.out.println("total edges after = "+totalEdges);
            if (totalEdges == totalComponents)break;
        }
        if (totalEdges==1)return minDays+1;
        return minDays;
    }


    private void dfs_operate(int[][] graph, int[][] marked, int i, int j, int[] maxEdgeIndex) {

        if (marked[i][j] < 0)
            return;

        marked[i][j] = -1;

        if (graph[i][j] > graph[maxEdgeIndex[0]][maxEdgeIndex[1]]) {
            maxEdgeIndex[0] = i;
            maxEdgeIndex[1] = j;
        }

        // visit on edges
        if (isEdge(graph, i + 1, j)) {
            dfs_operate(graph, marked, i + 1, j, maxEdgeIndex);
        }
        if (isEdge(graph, i - 1, j)) {
            dfs_operate(graph, marked, i - 1, j, maxEdgeIndex);
        }
        if (isEdge(graph, i, j + 1)) {
            dfs_operate(graph, marked, i, j + 1, maxEdgeIndex);
        }
        if (isEdge(graph, i, j - 1)) {
            dfs_operate(graph, marked, i, j - 1, maxEdgeIndex);
        }

    }

    private void fillWater(int[][] graph, int i, int j) {
        if (graph[i][j]>1) {
            totalEdges-=(2*graph[i][j]-1);
            minDays++;
            graph[i][j] = 0;
        }

        if (isEdge(graph, i + 1, j)) {
            if (graph[i+1][j]>1)
                graph[i+1][j]--;
        }
        if (isEdge(graph, i - 1, j)) {
            if (graph[i-1][j]>1)
                graph[i-1][j]--;
        }
        if (isEdge(graph, i, j + 1)) {
            if (graph[i][j+1]>1)
                graph[i][j+1]--;
        }
        if (isEdge(graph, i, j - 1)) {
            if (graph[i][j - 1] > 1)
                graph[i][j - 1]--;
        }
    }

    private void printMat(int[][] mat) {
        System.out.println("Printing...");
        for (int[] i : mat) {
            System.out.println(Arrays.toString(i));
        }
    }

    private boolean isEdge(int[][] grid, int i, int j) {
        return !isInvalid(i, j, grid.length, grid[0].length) && isIsland(grid, i, j);
    }

    private boolean isIsland(int[][] grid, int i, int j) {
        return grid[i][j] != 0;
    }

    private boolean isInvalid(int i, int j, int rows, int cols) {
        return i < 0 || i >= rows || j < 0 || j >= cols;
    }

    public static void main(String[] args) {
        //int[][] grid = {{0, 1, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        int[][] grid = {{1,1}};
        DisconnectedIslands obj = new DisconnectedIslands();
        System.out.println("Min days =  " + obj.minDays(grid));
        System.out.println("Original Grid:");
        obj.printMat(grid);
    }
}
