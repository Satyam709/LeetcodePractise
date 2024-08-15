
import java.util.HashSet;


public class LongestSubStringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, crntL = 0;
        HashSet<Character> set = new HashSet<>();

        int start = 0;
        for (int i = 0; i < s.length() && start<s.length(); i++) {
            char ch = s.charAt(i);
            if (!set.contains(ch)) {
                set.add(ch);
                crntL++;

            } else {
                l = Math.max(crntL, l);
                do
                {
                    if (start == s.length())break;
                    crntL--;
                    set.remove(s.charAt(start));
                }
                while (s.charAt(start++) != ch);
                i--;
            }
        }
        l = Math.max(l,crntL);
        return l;
    }

    public static void main(String[] args) {
        LongestSubStringWithoutRepeating obj = new LongestSubStringWithoutRepeating();

        String s = "bbbbbb";
        System.out.println(obj.lengthOfLongestSubstring(s));
    }
}
