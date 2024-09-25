import java.util.Arrays;
import java.util.HashMap;

public class EvenVowels {
    public int findTheLongestSubstring(String s) {

        VowelsDealer vow = new VowelsDealer();
        

        int left = 0 ,right =0 ;
        for (int i = 0; i < s.length(); i++) {
            vow.add(s.charAt(i));

        }

        return 0;
    }

    private static class VowelsDealer {

        private final int[] vow;
        private final boolean[] valid;

        VowelsDealer() {
            vow = new int[5];
            valid = new boolean[5];
            Arrays.fill(valid,true);
        }
        private void add(Character ch){
            int i = mapper(ch);
            if (i<0)return;
            int t = ++vow[i];
            valid[i] = t % 2 == 0;
        }
        private boolean isValid(){
            for (int i = 0; i < 5; i++) {
                if (!valid[i])return false;
            }
            return true;
        }
        private int mapper(Character ch) {
            return switch (ch) {
                case 'a' -> 0;
                case 'e' -> 1;
                case 'i' -> 2;
                case 'o' -> 3;
                case 'u' -> 4;
                default -> -1;
            };
        }
    }



}
