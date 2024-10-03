public class SubStrContaingABC_SW {
    public static int numberOfSubstrings(String s) {
        int subArr = 0;
        int[] freq = new int[3];
        int l = 0;
        for (int r = 0; r < s.length(); r++) {

            freq[s.charAt(r) - 'a']++;

            while (l<r && count(freq) == 3) {

                freq[s.charAt(l) - 'a'] = Math.max(0, freq[s.charAt(l) - 'a'] - 1);
                l++;

                subArr += s.length()-r; // at least the root is counted
            }
        }
        return subArr;
    }

    private static int count(int[] freq) {
        int out = Math.min(freq[0], 1) + Math.min(freq[1], 1) + Math.min(freq[2], 1);
        return out;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        System.out.println(numberOfSubstrings(s));
    }
}
