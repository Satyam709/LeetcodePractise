import java.util.Arrays;

public class SpiralMatrix_8_9 {

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int lr = rStart, ur = lr, lc = cStart, uc = lc;
        int[][] out = new int[rows * cols][];
        int k = 0;
        outer:
        while (k != rows * cols) {
            for (int i = lc; i <= uc; i++) {
                if (isInvalid(lr, rows, i, cols))
                    continue;
                if (k == rows * cols) break outer;
                out[k++] = new int[]{lr, i};
            }
            uc++;

            for (int i = lr; i <= ur; i++) {
                if (isInvalid(i, rows, uc, cols)) continue;
                if (k == rows * cols) break outer;
                out[k++] = new int[]{i, uc};
            }
            ur++;

            for (int i = uc; i >= lc; i--) {
                if (isInvalid(ur,rows, i, cols)) continue;
                if (k == rows * cols) break outer;
                out[k++] = new int[]{ur, i};
            }
            lc--;

            for (int i = ur; i >= lr; i--) {
                if (isInvalid(i, rows, lc, cols)) continue;
                if (k == rows * cols) break outer;
                out[k++] = new int[]{i, lc};
            }
            lr--;

        }
        for (int[] i : out) {
            System.out.println(Arrays.toString(i));
        }
        return out;
    }

    private boolean isInvalid(int i, int rows, int j, int cols) {
        return i < 0 || j < 0 || j >= cols || i >= rows;
    }

    public static void main(String[] args) {
        SpiralMatrix_8_9 obj = new SpiralMatrix_8_9();
        obj.spiralMatrixIII(5, 6, 1, 4);
    }
}
