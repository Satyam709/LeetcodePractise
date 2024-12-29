import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;

public class WaysToFormWords {

    public static int numWays(String[] words, String target) {

        int len = words[0].length();
        int lt = (int) Math.pow(10, 9) + 7;

        if (len < target.length()) return 0;
        long count = 0;

        int[][] mapper = new int[len][26];

        for (String word : words) {
            for (int i = 0; i < len; i++) {
                int val = word.charAt(i) - 'a';
                mapper[i][val]++;
            }
        }

        int tarLen = target.length();
        long[] freqData = new long[target.length()];
        freqData[0] = 1 ;

        for (int i = 0; i < len; i++) {
            System.out.println("running for index = " + i);
            long[] tmp = Arrays.copyOf(freqData,tarLen);
            for (int j = 0; j < tarLen; j++) {

                long prevFreq = freqData[j];

                if (prevFreq < 1) continue;

                int freq = mapper[i][target.charAt(j) - 'a'];

                if (freq < 1) continue;

                prevFreq *= freq;
                if (j == tarLen - 1) count += prevFreq;
                else {
                    System.out.println("updated with "+prevFreq +" for j="+j);
                    tmp[j + 1] += (int) (prevFreq % lt);
                }

            }
            System.out.println("freq Data\n"+Arrays.toString(freqData));
            System.out.println("tmp data\n"+Arrays.toString(tmp));
            freqData = tmp;
        }

        System.out.println(Arrays.deepToString(mapper));

        return (int) (count % lt);
    }

    public static void main(String[] args) {
        String[] words = {"acca", "bbbb", "caca"};
        String target = "aba";

        String[] words2 = {"abba", "baab"};
        String target2 = "bab";

        String[] words3 = {"cabbaacaaaccaabbbbaccacbabbbcb", "bbcabcbcccbcacbbbaacacaaabbbac", "cbabcaacbcaaabbcbaabaababbacbc", "aacabbbcaaccaabbaccacabccaacca", "bbabbaabcaabccbbabccaaccbabcab", "bcaccbbaaccaabcbabbacaccbbcbbb", "cbbcbcaaaacacabbbabacbaabbabaa", "cbbbbbbcccbabbacacacacccbbccca", "bcbccbccacccacaababcbcbbacbbbc", "ccacaabaaabbbacacbacbaaacbcaca", "bacaaaabaabccbcbbaacacccabbbcb", "bcbcbcabbccabacbcbcaccacbcaaab", "babbbcccbbbbbaabbbacbbaabaabcc", "baaaacaaacbbaacccababbaacccbcb", "babbaaabaaccaabacbbbacbcbababa", "cbacacbacaaacbaaaabacbbccccaca", "bcbcaccaabacaacaaaccaabbcacaaa", "cccbabccaabbcbccbbabaaacbacaaa", "bbbcabacbbcabcbcaaccbcacacccca", "ccccbbaababacbabcaacabaccbabaa", "caaabccbcaaccabbcbcaacccbcacba", "cccbcaacbabaacbaaabbbbcbbbbcbb", "cababbcacbabcbaababcbcabbaabba", "aaaacacaaccbacacbbbbccaabcccca", "cbcaaaaabacbacaccbcbcbccaabaac", "bcbbccbabaccabcccacbbaacbbcbba", "cccbabbbcbbabccbbabbbbcaaccaab", "acccacccaabbcaccbcaaccbababacc", "bcacabaacccbbcbbacabbbbbcaaaab", "cacccaacbcbccbabccabbcbabbcacc", "aacabbabcaacbaaacaabcabcaccaab", "cccacabacbabccbccaaaaabbcacbcc", "cabaacacacaaabaacaabababccbaaa", "caabaccaacccbaabcacbcbbabccabc", "bcbbccbbaaacbaacbccbcbababcacb", "bbabbcabcbbcababbbbccabaaccbca", "cacbbbccabaaaaccacbcbabaabbcba", "ccbcacbabababbbcbcabbcccaccbca", "acccabcacbcbbcbccaccaacbabcaab", "ccacaabcbbaabaaccbabcbacaaabaa", "cbabbbbcabbbbcbccabaabccaccaca", "acbbbbbccabacabcbbabcaacbbaacc", "baaababbcabcacbbcbabacbcbaaabc", "cabbcabcbbacaaaaacbcbbcacaccac"};
        String target3 = "acbaccacbbaaabbbabac";
        System.out.println(numWays(words3, target3));
    }
}
