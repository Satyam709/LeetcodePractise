public class Atoi {
    public static int myAtoi(String s) {

        char[] ch = s.toCharArray();

        int i = 0, sign = 1;
        while (ch[i] == ' ') i++;

        if (ch[i] == '-') {
            sign = -1;

            i++;
        }
        long crnt = 0;


        long max = Integer.MAX_VALUE;
        long min = Integer.MIN_VALUE;

        while (ch[i] == '0') i++;

        for (; i < s.length(); i++) {
            char c = ch[i];
            if (!Character.isDigit(c)) break;

            int d = sign * (c - '0');

            crnt = crnt * 10 + d;

            if (crnt> max) {
                crnt = max;
                break;
            }
            if (crnt< min) {
                crnt = min;
                break;
            }

        }

        return (int) crnt;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("   -042"));
    }
}
