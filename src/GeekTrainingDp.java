public class GeekTrainingDp {
    public int maximumPoints(int[][] arr, int N) {
        int n = arr.length;

        int p1 = arr[0][0];
        int p2 = arr[0][1];
        int p3 = arr[0][2];

        for (int i = 1; i < n; i++) {
            int cp1 = 0 , cp2 =0,cp3=0;

            cp1 = arr[i][0] + Math.max(p2, p3);

            cp2 = arr[i][1] + Math.max(p1, p3);

            cp3 = arr[i][2] + Math.max(p2, p1);

            p1 = cp1;
            p2 = cp2;
            p3 = cp3;
        }

        return Math.max(p1, Math.max(p2, p3));
    }

    public static void main(String[] args) {
        GeekTrainingDp obj = new GeekTrainingDp();

        int[][] arr = {{1, 2, 5},
                {3, 1, 1},
                {3, 2, 3}};
        int n =3;

        System.out.println(obj.maximumPoints(arr,n));
    }
}
