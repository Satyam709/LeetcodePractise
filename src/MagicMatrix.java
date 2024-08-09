public class MagicMatrix {
    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;

        // Iterate over each possible 3x3 subgrid
        for (int j = 0; j <= row - 3; j++) {
            for (int i = 0; i <= col - 3; i++) {
                if (validateRows(grid, i, j) == -1) {
                    continue;
                }
                if (validateDiag(grid, i, j) == -1) {
                    continue;
                }
                if (validateCols(grid, i, j) == -1) {
                    continue;
                }
                count++;
            }
        }
        return count;
    }

    private int validateRows(int[][] grid, int i, int j) {
        int[] count = new int[10];
        int sum = 0, preSum = 0;

        for (int k = j; k < j + 3; k++) { // Iterate over each row in the 3x3 grid
            preSum = sum;
            sum = 0;
            for (int l = i; l < i + 3; l++) { // Iterate over each element in the row
                int e = grid[k][l];

                // Check range
                if (!(e < 10 && e > 0))
                    return -1;

                // Check for duplicate elements
                if (count[e] > 0)
                    return -1;

                sum += e;
                count[e]++;
            }

            if (k != j && sum != preSum) // Validate sum consistency across rows
                return -1;
        }

        return sum;
    }

    private int validateDiag(int[][] grid, int i, int j) {
        // Sum for the diagonals
        int sumLeft = grid[j][i] + grid[j + 1][i + 1] + grid[j + 2][i + 2];
        int sumRight = grid[j][i + 2] + grid[j + 1][i + 1] + grid[j + 2][i];

        return sumRight == sumLeft ? sumLeft : -1;
    }

    private int validateCols(int[][] grid, int i, int j) {
        int[] count = new int[10];
        int sum = 0, preSum = 0;

        for (int k = i; k < i + 3; k++) { // Iterate over each column in the 3x3 grid
            preSum = sum;
            sum = 0;
            for (int l = j; l < j + 3; l++) { // Iterate over each element in the column
                int e = grid[l][k];

                // Check range
                if (!(e < 10 && e > 0))
                    return -1;

                // Check for duplicate elements
                if (count[e] > 0)
                    return -1;

                sum += e;
                count[e]++;
            }

            if (k != i && sum != preSum) // Validate sum consistency across columns
                return -1;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] grid = {{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}};
        MagicMatrix obj = new MagicMatrix();
        System.out.println("count = " + obj.numMagicSquaresInside(grid));  // Output: 1
    }
}
