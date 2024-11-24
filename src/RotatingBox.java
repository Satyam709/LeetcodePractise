import java.util.Arrays;

public class RotatingBox {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] out = new char[n][m];
        for (int i = 0; i < box.length ; i++)
            rotate(box,i);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                out[j][m-1-i] = box[i][j];
            }
        }

        System.out.println(Arrays.deepToString(out));

        return out;
    }

    private void rotate(char[][] box, int row) {
        int lt, i = box[row].length-1;
        lt = i;
        for (; i >= 0; i--) {
            if (box[row][i] == '#') {
                swap(box, row, i, lt--);
            } else if (box[row][i] == '*') {
                lt = i-1;;
            }
        }
    }

    private void swap(char[][] box, int row, int i, int j) {
        char t = box[row][i];
        box[row][i] = box[row][j];
        box[row][j] = t;
    }

    public static void main(String[] args) {
        char[][] box = {
                {'#', '.', '.', '*', '*', '.'},
                {'#', '.', '#', '*', '.', '.'},
                {'#', '#', '#', '*', '#', '.'}
        };
        RotatingBox obj = new RotatingBox();
//        obj.rotate(box,2);
//        obj.rotate(box,1);
//        obj.rotate(box,0);
        System.out.println(Arrays.deepToString(obj.rotateTheBox(box)));
    }
}
