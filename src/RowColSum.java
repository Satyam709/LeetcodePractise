public class RowColSum {

    private int rowLength;
    private int colLength;

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {

        rowLength = rowSum.length;
        colLength = colSum.length;

        int[][] mat = new int[rowLength][colLength];

        for (int i = 0; i < rowSum.length; i++) {
            int rowSumI = rowSum[i];
            for (int j = 0; j < colSum.length; j++) {
                int colSumJ = colSum[j];

                if (mat[i][j]+rowSumI<=colSumJ){
                    mat[i][j] += rowSumI;
                } else {
                    
                }

            }
        }

        return mat;
    }

    private boolean isValidIndex(int i, int j) {
        return !(i < 0 || j < 0 || i >= rowLength || j >= colLength);
    }

}
