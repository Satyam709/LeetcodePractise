import java.util.Arrays;

public class Daily_10_03_2025 {

    public long countOfSubstrings(String word, int k) {
        return getSubStings(word,k);
    }

    private int getSubStings(String word, int k) {
        int[] freq = new int[26];
        int l = 0, count = 0;

        for (int r = 0; r < word.length(); r++) {
            char ch = word.charAt(r);
            if (isVowel(ch)) {
                freq[ch - 'a']++;
            }
            int vowelCount = Arrays.stream(freq).sum();
            int consonants = r - l + 1 - vowelCount;

            if (consonants == k && gotAllVowels(freq)) {
                count++;
                System.out.println("l = "+l +" r = "+r);

            }else if (consonants>k){
                while (consonants>k) {
                    System.out.println("removing "+ word.charAt(l));
                    if (isVowel(word.charAt(l))) {
                        vowelCount--;
                        freq[word.charAt(l) - 'a']--;
                    }else
                        consonants--;
                    System.out.println("now v = "+vowelCount+" c = "+consonants);
                    if (gotAllVowels(freq)) count++;
                    l++;
                }
                if (vowelCount == 5 && k == consonants)count++;
            }

            if (r == word.length()-1){
                System.out.println("extras");
                while (consonants==k) {
                    System.out.println("removing "+ word.charAt(l));
                    if (isVowel(word.charAt(l))) {
                        vowelCount--;
                        freq[word.charAt(l) - 'a']--;
                    }else
                        consonants--;
                    System.out.println("now v = "+vowelCount+" c = "+consonants);
                    if (gotAllVowels(freq) && consonants==k) count++;
                    else break;
                    l++;
                }
            }
        }
        return count;
    }

    private boolean gotAllVowels(int[] freq) {
        int count = 0;
        count += Math.min(freq[0], 1);
        count += Math.min(freq['e' - 'a'], 1);
        count += Math.min(freq['i' - 'a'], 1);
        count += Math.min(freq['o' - 'a'], 1);
        count += Math.min(freq['u' - 'a'], 1);
        return count == 5;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static void main(String[] args) {
        String word = "iqeaouqi";
        int k = 2;

        Daily_10_03_2025 obj = new Daily_10_03_2025();
        System.out.println(obj.getSubStings(word,k));
    }
}
