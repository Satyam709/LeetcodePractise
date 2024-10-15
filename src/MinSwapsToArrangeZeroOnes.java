public class MinSwapsToArrangeZeroOnes {
    public static long minimumSteps(String s) {
        long minSwaps = 0;
        int l = s.length(), ones = 0;


        for (int i = 0; i < l; i++) {
            if (s.charAt(i) == '1')
                ones++;
        }

        int right = l - ones, left = right - 1;

        while (right < l) {

            while (s.charAt(right) != '0') {
                right++;
                if (right >= l) return minSwaps;
            }

            while (s.charAt(left) != '1') left--;

            minSwaps += right++ - left--;
        }

        return minSwaps;
    }

    public static long minimumSteps2(String s) {
        int lt = 0;
        long t = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == '0') t += i - lt++;
        return t;
    }

    public static void main(String[] args) {
        String s = "101";
        System.out.println(minimumSteps2(s));
    }
}
