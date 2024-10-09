public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        char[] ch = s.toCharArray();

        int max = 0, l = 0, r = 0;
        for (int i = 1; i < s.length(); i++) {

            int distance = 0;
            int lw = i,up;

            while (i<s.length()-1 && ch[i+1] == ch[i])i++;

            up=i;

            while (lw - distance >= 0 && up + distance < s.length() && ch[lw - distance] == ch[up + distance])
                distance++;

            int len = 2 * (distance - 1) + up-lw + 1;

            if (max < len) {
                max = len;
                l = lw - (distance - 1);
                r = up + distance;
            }

        }
        return s.substring(l, r);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("satyammaytas"));
    }

}
