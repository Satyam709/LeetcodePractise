import java.util.ArrayList;
import java.util.List;

public class kthLexicographicalOrder {
    public int findKthNumber(int n, int k) {
        long crnt = 1;
        for (int i = 1; i < k; i++) {

            if (crnt * 10 <= n) crnt *= 10;

            else {
                int lastDigit = (int)crnt % 10;

                if (lastDigit == 9) {
                    crnt++;
                    while (crnt%10==0)crnt/=10;
                }
                else {
                    if (crnt + 1 > n) {
                        crnt /= 10;
                    }
                    crnt++;
                }
            }
        }
        return (int)crnt;
    }

    public static void main(String[] args) {

        kthLexicographicalOrder obj = new kthLexicographicalOrder();

        int k =593124772;
        int n = 596516650;

        System.out.println(obj.findKthNumber(n,k));
    }
}
