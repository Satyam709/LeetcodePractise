import java.util.HashMap;
import java.util.HashSet;

public class ExtraChars {
    public static int minExtraChar(String s, String[] dictionary) {

        int l = s.length();

        HashSet<String> map = new HashSet<>(l*l);

        for (int i = 0; i < l; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = i; j < l; j++) {
                str.append(s.charAt(j));
                map.add(str.toString());
            }
        }

        System.out.println(map);
        return 0;
    }

    public static void main(String[] args) {
        String s = "leetscode";
        String[] dictionary = {"leet","code","leetcode"};
        minExtraChar(s,dictionary);
    }
}
