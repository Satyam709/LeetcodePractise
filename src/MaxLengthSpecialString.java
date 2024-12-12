import java.util.HashMap;

public class MaxLengthSpecialString {
    public static int maximumLength(String s) {
        int max = -1;
        HashMap<String, Integer> map = new HashMap<>();
        int l = 0;
        for (int r = 0; r <= s.length(); r++) {

            char ch = r == s.length() ? '.' : s.charAt(r); // creates a sudo char for last evaluation

            if (s.charAt(l) != ch) { // if the window gets a different character, evaluate it

                int sub_len = r - l;

                String sub = s.substring(l, r);
                int len = sub_len;

                for (int i = 1; i <= sub_len; i++) {
                    String key = sub.substring(0, i);
                    int val = map.getOrDefault(key, 0) + len--;
                    if (val > 2) {
                        max = Math.max(i, max);
                    }

                    map.put(key, val);
                    l = r;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "aaaa";
        System.out.println("out1 = " + maximumLength(s));
    }

}
