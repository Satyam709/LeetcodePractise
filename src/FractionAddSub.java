import java.util.Arrays;

public class FractionAddSub {
    public String fractionAddition(String expression) {

        int opIndex = 0;

        int num = 0, den = 1;

        int[] sum = {num, den};

        while (opIndex < expression.length()) {

            int t = opIndex;
            while (expression.charAt(opIndex)!='/')opIndex++;
            num = Integer.parseInt(expression.substring(t,opIndex++));

            t = opIndex;
            while (opIndex<expression.length() && Character.isDigit(expression.charAt(opIndex)))opIndex++;
            den = Integer.parseInt(expression.substring(t,opIndex));

            sum = fractionAdd(sum, new int[]{num, den});

        }
        StringBuilder str = new StringBuilder(4);
        int gcd = gcd(Math.abs(sum[0]), sum[1]);
        num = sum[0] / gcd;
        den = sum[1] / gcd;
        str.append(num).append("/").append(den);
        return str.toString();
    }

    private int[] fractionAdd(int[] frac1, int[] frac2) {
        return new int[]{frac1[0] * frac2[1] + frac2[0] * frac1[1], frac1[1] * frac2[1]};
    }

    private int gcd(int a, int b) {
        if (b < a) {
            int t = a;
            a = b;
            b = t;
        }
        while (a != 0) {
            int t = b % a;
            b = a;
            a = t;
        }
        return b;
    }

    public static void main(String[] args) {
        FractionAddSub obj = new FractionAddSub();
        String exp = "-5/2+10/3+7/9";
        System.out.println(obj.fractionAddition(exp));
    }

}
