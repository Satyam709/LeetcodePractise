import java.util.Collections;
import java.util.PriorityQueue;

public class MinPush_6_8_24 {

    private record Freq(char ch,int freq) implements Comparable<Freq>{
        @Override
        public int compareTo(Freq o) {
            return Integer.compare(this.freq,o.freq);
        }
    }
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char i : word.toCharArray()){
            freq[i-97]++;
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < 26; i++) {
            if (freq[i]!=0) {
                System.out.println((char) (i + 97) + " -> " + freq[i]);
                pq.add(new Freq((char) (i + 97),freq[i]));
            }
        }
        System.out.println(pq);
        int i =8,minSum =0;
        while(!pq.isEmpty()){
            minSum += i/8 * freq[pq.poll().ch - 97];
            i++;
        }
        return minSum;
    }

    public static void main(String[] args) {
        String s  ="abzaqsqcyrbzsrvamylmyxdjl";
        MinPush_6_8_24 obj = new MinPush_6_8_24();
        System.out.println(obj.minimumPushes(s));
    }
}
