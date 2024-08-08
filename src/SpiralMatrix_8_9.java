import java.util.Arrays;

public class SpiralMatrix_8_9 {

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int lr = rStart, ur = lr, lc = cStart, uc = lc;
        int[][] out = new int[rows * cols][];
        int k = 0;
        outer:
        while (k != rows * cols) {
            // Move right
            for (int i = Math.max(lc, 0); i <= Math.min(cols - 1, uc); i++) {
                if (isInvalid(lr, rows)) break;
                if (k == rows * cols) break outer;
                out[k++] = new int[]{lr, i};
            }
            uc++;

            // Move down
            for (int i = Math.max(0, lr); i <= Math.min(rows - 1, ur); i++) {
                if (isInvalid(uc, cols)) break;
                if (k == rows * cols) break outer;
                out[k++] = new int[]{i, uc};
            }
            ur++;

            // Move left
            for (int i = Math.min(cols - 1, uc); i >= Math.max(0, lc); i--) {
                if (isInvalid(ur, rows)) break;
                if (k == rows * cols) break outer;
                out[k++] = new int[]{ur, i};
            }
            lc--;

            // Move up
            for (int i = Math.min(rows - 1, ur); i >= Math.max(0, lr); i--) {
                if (isInvalid(lc, cols)) break;
                if (k == rows * cols) break outer;
                out[k++] = new int[]{i, lc};
            }
            lr--;
        }
        return out;
    }

    private boolean isInvalid(int i, int limit) {
        return i < 0 || i >= limit;
    }

    public static void main(String[] args) {
        SpiralMatrix_8_9 obj = new SpiralMatrix_8_9();
        int[][] out = obj.spiralMatrixIII(5, 6, 1, 4);
        int k=0;
        for (int[] i : out) {
            System.out.println(k++ +" "+Arrays.toString(i));
        }
    }
}
