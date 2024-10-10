public class PowXN {
    public static double myPow(double x, int n) {

        if (n == 0) return 1;
        if (n == 1 || n == -1) return x;

        double pow = x;
        double remPow = 1.0;

        for (int i = n; i != 1; ) {

            int rem = i % 2;
            System.out.println("rem = " + rem);
            if (rem != 0) {
                if (i < 0) i++;
                else i--;
            }
            i /= 2;
            System.out.println("i = " + i);

            if (rem < 0) rem *= -1;
            if (i < 0) i *= -1;
            if (rem > 0) {
                remPow *= pow;
            }
            if (i > 0) {
                pow *= pow;
            }
        }
        pow*=remPow;
        return n<0?1/pow:pow;
    }
    public static double myPow2(double x, int n) {

        long nn = n;
        if (nn<0){
            x = 1/x;
            nn*=-1;
        }
        double pow = x;
        //System.out.println(pow);
        double remPow = 1.0;

        for (long i = nn; i > 1; ) {

            int rem =(int) i % 2;
            //System.out.println("rem"+rem);
            if (rem != 0) {
                i--;
                remPow *= pow;
            }

            else {
                pow *= pow;
                //System.out.println("i" + i);
                i /= 2;
            }
        }
        pow*=remPow;
        return pow;
    }

    public static void main(String[] args) {
        System.out.println(myPow2(2, -2));
    }
}
