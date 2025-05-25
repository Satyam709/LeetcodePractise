public class Daily_25_05_2025 {
    public static int longestPalindrome(String[] words) {
        int len = 0;
        boolean isRep = false;
        int[][] freq = new int[26][26];
        for (String s : words) {
            freq[s.charAt(0) - 'a'][s.charAt(1) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i != j) {
                    len += Math.min(freq[i][j], freq[j][i]);
                } else {
                    len += freq[i][j] - (freq[i][j] & 1);
                    isRep |= (freq[i][j] & 1) == 1;
                }
            }
        }
        return len * 2 + (isRep ? 2 : 0);
    }

    public static void main(String[] args) {
        String[] arr = {"qo", "fo", "fq", "qf", "fo", "ff", "qq", "qf", "of", "of", "oo", "of", "of", "qf", "qf", "of"};
        System.out.println(longestPalindrome(arr));
    }
}
