public class MaxNoByBInConcat {
    public static int maxGoodNumber(int[] a) {
        int d0 = (int) (Math.log(a[0])/Math.log(2))+1;
        int d1 = (int) (Math.log(a[1])/Math.log(2))+1;
        int d2 = (int) (Math.log(a[2])/Math.log(2))+1;

        int max = 0;
        double d;

        d= a[0]<<(d1+d2) | a[1]<<(d2) | a[2];
        max= (int) Math.max(d,max);

        d= a[0]<<(d1+d2) | a[2]<<(d1) | a[1];
        max= (int) Math.max(d,max);

        d= a[1]<<(d0+d2) | a[0]<<(d2) | a[2];
        max= (int) Math.max(d,max);

        d= a[1]<<(d0+d2) | a[2]<<(d0) | a[0];
        max= (int) Math.max(d,max);

        d= a[2]<<(d1+d0) | a[0]<<(d1) | a[1];
        max= (int) Math.max(d,max);

        d= a[2]<<(d1+d0) | a[1]<<(d0) | a[0];
        max= (int) Math.max(d,max);

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxGoodNumber(new int[]{1,11,5}));
    }
}
