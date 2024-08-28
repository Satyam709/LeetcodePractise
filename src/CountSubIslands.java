import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class UF {
    private final int[] rank;
    private final int[] arr;
    private final int size;

    UF(int size) {
        this.size = size;
        rank = new int[size];
        Arrays.fill(rank, 1);
        arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return;

        if (rank[rootA] < rank[rootB]) {
            arr[rootA] = rootB;
            rank[rootB] += rank[rootA];
        } else {
            arr[rootB] = rootA;
            rank[rootA] += rank[rootB];
        }
        System.out.println(Arrays.toString(arr));
    }

    private int find(int b) {
        int i = b;
        while (arr[i] != i) {
            int t = arr[i];
            arr[i] = arr[arr[i]];
            i = t;
        }
        return i;
    }

    public boolean connected(int a, int b) {
        return find(a) == find(b);
    }
}

public class CountSubIslands {

    public int countSubIslands(int[][] grid1, int[][] grid2) {

        int subIslands = 0;
        UF uf1 = new UF(grid1.length * grid1[0].length);
        UF uf2 = new UF(grid1.length * grid1[0].length);

        for (int i = 1; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid1[i][j] == 0) continue;

                if (isValid(grid1.length, i-1, grid1[0].length, j) && grid1[i-1][j] != 0) {
                    uf1.union(to1D(i,j, grid1.length),to1D(i-1,j, grid1.length));
                }
                if (isValid(grid1.length, i, grid1[0].length, j-1) && grid1[i][j-1] != 0) {
                    uf1.union(to1D(i,j, grid1.length),to1D(i,j-1, grid1.length));
                }
            }
        }

        HashSet<Integer> set = new HashSet<>();

        for (int i = 1; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 0) continue;



                if (isValid(grid1.length, i-1, grid1[0].length, j) && grid2[i-1][j] != 0) {

                    uf2.union(to1D(i,j, grid1.length),to1D(i-1,j, grid1.length));
                    if (!uf1.connected(to1D(i,j, grid1.length),to1D(i,j, grid1.length))){

                    }

                }
                if (isValid(grid1.length, i, grid1[0].length, j-1) && grid2[i][j-1] != 0) {
                    uf2.union(to1D(i,j, grid1.length),to1D(i,j-1, grid1.length));
                }
            }
        }

        return subIslands;
    }

    private int to1D(int i, int j, int r) {
        return i * r + j;
    }

    private int[] to2D(int i, int r) {
        return new int[]{i / r, i % r};
    }

    private boolean isValid(int rows, int i, int cols, int j) {
        return i < rows && i >= 0 && j >= 0 && j < cols;
    }

    public static void main(String[] args) {
        int[][] grid1 = {{1,0,1,0,1},{1,1,1,1,1},{0,0,0,0,0},{1,1,1,1,1},{1,0,1,0,1}},
                grid2 = {{0,0,0,0,0},{1,1,1,1,1},{0,1,0,1,0},{0,1,0,1,0},{1,0,0,0,1}};

        CountSubIslands obj = new CountSubIslands();
        System.out.println(obj.countSubIslands(grid1,grid2));
    }
}
