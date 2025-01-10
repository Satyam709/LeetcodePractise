import java.util.LinkedList;
import java.util.List;

public class WordSubsets {
    public static List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> res = new LinkedList<>();
        int[] cache = new int[26];


        for (String i : words2) {
            int[] ttt = getCount(i);
            for (int j = 0; j < 26; j++) {
                cache[j] = Math.max(cache[j],ttt[j]);
            }
        }

        for (String w : words1) {
            int[] freqW = getCount(w);
            boolean isUni = true;

            for (int i = 0; i < 26; i++) {
                if (cache[i] > freqW[i])
                {
                    isUni = false;
                    break;
                }
            }

            if (isUni) res.add(w);
        }
        return res;
    }

    private static int[] getCount(String w) {
        int[] freq = new int[26];
        for (char i : w.toCharArray())
            freq[i - 'a']++;
        return freq;
    }

    public static void main(String[] args) {
        String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"}, words2 = {"e", "o"};

        System.out.println("out -> " + wordSubsets(words1, words2));
    }
}