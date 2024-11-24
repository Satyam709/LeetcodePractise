public class MinMatrixSumAfterAdjacentSignChanges {
    public static long maxMatrixSum(int[][] m) {
        long sum = 0;
        long min = Integer.MAX_VALUE;
        int minus = 0;
        for (int[] ints : m) {
            for (int j :ints) {
                int crnt = j;

                if (crnt < 0) {
                    minus++;
                    crnt *= -1;
                }
                min = Math.min(min, crnt);
                sum += crnt;
            }
        }
        if (minus % 2 == 0) return sum;
        return sum - 2 * min;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{-1,-2,-3},{1,2,3}};
        System.out.println(maxMatrixSum(matrix));
    }
}
