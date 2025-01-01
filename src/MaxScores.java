import java.util.Arrays;

public class MaxScores {
    public static int maxScore(String s) {
        int max = 0;
        int[] lc = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            lc[i] = lc[i - 1] + (s.charAt(i - 1) == '0' ? 1 : 0);
        }
        int rc = 0;
        for (int i = s.length()-1; i >0 ; i--) {
            rc+= s.charAt(i) == '1'?1:0;
            max = Math.max(rc+lc[i],max);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "011101";
        System.out.println("out -> "+ maxScore(s));
    }
}
