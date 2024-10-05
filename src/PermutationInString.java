public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];


        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
        }

        int l = 0, r = 0;

        while (r < s2.length() && freq[s2.charAt(r) - 'a'] == 0) r++;

        l = r;

        int len = s1.length();

        for (; r < s2.length(); r++) {

            freq[s2.charAt(r) - 'a']--;
            len--;

            while (freq[s2.charAt(r) - 'a'] < 0) {
                freq[s2.charAt(l) - 'a']++;
                l++;
                len++;
            }

            if (len<=0 )return true;

        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "acd", s2 = "dcda";
        System.out.println(checkInclusion(s1,s2));
    }
}
