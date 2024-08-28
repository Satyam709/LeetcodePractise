public class Compliment {
    public int findComplement(int n) {
        StringBuilder s = new StringBuilder();
        while (n > 0) {
            s.append(n % 2);
            n /= 2;
        }
        String st = s.toString();

        int out = 0;

        System.out.println("in bin rev =" + st);

        for (int i = s.length() - 1; i >= 0; i--) {
            System.out.println('1' - st.charAt(i));
            out += ('1' - s.charAt(i)) * (int) Math.pow(2, i);
        }
        return out;
    }

    // method 2

    public int findComplement2(int n) {
        int b = 0, m = n;
        while (n > 0) {
            b++;
            n >>= 1;
        }

        return (1 << b) - 1 - m; // 1 << b is equivalent to 2^b
    }


    public static void main(String[] args) {
        Compliment obj = new Compliment();
        int n = 2147483647;
        System.out.println(obj.findComplement2(n));
    }
}
