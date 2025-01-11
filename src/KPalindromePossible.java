import java.util.Arrays;
import java.util.HashSet;

public class KPalindromePossible {
    public static boolean canConstruct(String s, int k) {
        int[] freq = new int[26];
        for (char i : s.toCharArray()) {
            freq[i - 'a']++;
        }
        System.out.println(Arrays.toString(freq));
        HashSet<Character> odds = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0)
                odds.add((char) ('a' + i));
        }
        int lw = odds.size();
        return k<=s.length() && k>=lw;
    }
    public static void main(String[] args) {
        String s = "leetcode";
        int k = 6;
        System.out.println("out = " + canConstruct(s, k));
    }
}
