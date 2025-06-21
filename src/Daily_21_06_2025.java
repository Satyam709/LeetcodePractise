public class Daily_21_06_2025 {
    public static int minimumDeletions(String word, int k) {
        int n = word.length();
        int min = word.length();
        int[] freq = new int[26];
        for (char ch : word.toCharArray()) {
            freq[ch - 'a']++;
        }
        int maxFreq = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) maxFreq = Math.max(maxFreq, freq[i]);
        }
        for (int i : freq) {
            if (i==0)continue;
            int del = getRequiredDeletions(freq, i, k, n);
            System.out.println("del for i = "+i+ " is = "+ del);
            min = Math.min(min, del);
        }
        return min;
    }

    private static int getRequiredDeletions(int[] freq, int x, int k, int n) {
        int fc = 0;
        for (int j = 0; j < 26; j++) {
            if (freq[j] < x) continue;
            fc += Math.min(x + k, freq[j]);
        }
        return n - fc;
    }

    public static void main(String[] args) {
        String word = "dabdcbdcdcd";
        int k = 2;
        System.out.println(minimumDeletions(word, k));
        word = "aabcaba";
        k = 0;
        System.out.println(minimumDeletions(word, k));
    }
}
