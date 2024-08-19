import java.util.Arrays;

public class RotateMatrix {

    public void rotate(int[][] matrix) {
        int s = matrix.length;

        for(int i=0;i<s;i++){
            for(int j=0;j<i;j++){
                swap(matrix,new int[]{i,j},new int[]{j,i});
            }
        }

        for (int i = 0; i < s; i++) {
            int lw = 0, hi = s-1;
            while (lw<hi)
                swap(matrix,new int[]{i,lw++},new int[]{i,hi--});
        }
    }

    private void swap(int[][] mat,int[]a,int[]b){
        int t = mat[a[0]][a[1]];
        mat[a[0]][a[1]] = mat[b[0]][b[1]];
        mat[b[0]][b[1]] = t;
    }

    public static void main(String[] args) {
        RotateMatrix obj = new RotateMatrix();
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        obj.rotate(mat);
    }

}
