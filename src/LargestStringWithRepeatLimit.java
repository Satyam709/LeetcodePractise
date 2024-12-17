import java.util.*;

public class LargestStringWithRepeatLimit {
    public static String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        PriorityQueue<Character> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (char i : s.toCharArray()){
            if (freq[i-'a'] == 0)pq.add(i);
            freq[i-'a']++;
        }

        System.out.println(Arrays.toString(freq));
        System.out.println(pq);

        StringBuilder str = new StringBuilder(s.length());

        int streak = 0;
        char streak_char = '0';
        char lastChar = '.';


        while(!pq.isEmpty()){
            char top = pq.peek();
            if (streak_char!=top){
                // reset streak
                streak = 0;
                streak_char = top;
            }

            if (streak<repeatLimit){
                if (freq[top-'a']>0) {
                    str.append(top);
                    freq[top-'a']--;
                    streak++;
                    if (freq[top-'a'] == 0)pq.poll();
                    if (lastChar!='.') {
                        pq.add(lastChar);
                        lastChar='.';
                    }
                }
            }
            else {
                pq.poll();
                if (pq.isEmpty())break;
                char secTop = pq.peek();
                lastChar = top;
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String s = "cczazcc";
        int repeatLimit = 1;
        System.out.println(repeatLimitedString(s, repeatLimit));

    }
}
