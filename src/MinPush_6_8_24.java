import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinPush_6_8_24 {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char i : word.toCharArray()) {
            freq[i - 97]++;
        }

        Arrays.sort(freq);

        int i = 8, minSum = 0, f, k = 26;
        while ((f = freq[--k]) != 0) {
            minSum += i / 8 * f;
            i++;
        }
        return minSum;
    }

    public static void main(String[] args) {
        String s = "abzaqsqcyrbzsrvamylmyxdjl";
        MinPush_6_8_24 obj = new MinPush_6_8_24();
        System.out.println(obj.minimumPushes(s));
    }
}
