import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
public class Daily_30_03_2025 {
    public static List<Integer> partitionLabels(String s) {
        int[] freq = new int[26];
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch-'a']++;
        }
        HashSet<Integer> set = new HashSet<>();
        int prevBreak = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            set.add(idx);
            freq[idx]--;

            int totalRemFreq = 0 ;
            for(int x : set){
                totalRemFreq += freq[x];
            }
            if (totalRemFreq == 0 ){
                li.add(i - prevBreak+1);
                prevBreak = i+1;
            }
        }
        return li;
    }
    public static void main(String[] args) {
//        Input: s = "ababcbacadefegdehijhklij"
//        Output: [9,7,8]
//        Explanation:
//        The partition is "ababcbaca", "defegde", "hijhklij".
//                This is a partition so that each letter appears in at most one part.
//                A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }
}
