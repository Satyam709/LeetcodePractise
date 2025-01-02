import java.util.Arrays;

public class CountVowelsStringsIInRanges {
    public static int[] vowelStrings(String[] words, int[][] queries) {
        int[] freq = new int[words.length];
        int[] res = new int[queries.length];

        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            if (isVowel(w.charAt(0)) && isVowel(w.charAt(w.length() - 1)))
                count++;

            freq[i] = count;
        }
        int t = 0;
        for (int[] i : queries) {
            int lw = i[0];
            int up = i[1];

            int result = freq[Math.min(up, words.length - 1)];
            if (lw > 0)
                result -= freq[lw - 1];
            res[t++] = result;
        }
        return res;
    }

    private static boolean isVowel(char ch) {
        return switch (ch) {
            case 'a', 'e', 'i', 'o', 'u' -> true;
            default -> false;
        };
    }

    public static void main(String[] args) {
        String[] words = {"aba", "bcb", "ece", "aa", "e"};
        int[][] queries = {{0, 2}, {1, 4}, {1, 1}};
        System.out.println(Arrays.toString(vowelStrings(words, queries)));
    }
}
