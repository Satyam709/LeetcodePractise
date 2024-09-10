public class LongestRepeating {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int left = 0, right = 0, maxFreq = 0;
        int[] freq = new int[26];
        while (right < s.length()) {

            int i = ++freq[s.charAt(right) - 'A'];
            maxFreq = Math.max(maxFreq, i);

            if (right - left + 1 - maxFreq > k) {
                left++;
                freq[s.charAt(left) - 'A']--;
            }

            max = Math.max(max, right - left + 1);
            right++;

        }
        return max;
    }
}
