import java.util.Collections;
import java.util.PriorityQueue;

public class GiftsPile_Easy {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : gifts) pq.add(i);
        long sum = 0;

        for (int i = 0; i < k; i++) {
            assert !pq.isEmpty();
            int x = pq.poll();
            int f = (int) Math.floor(Math.sqrt(x));
            pq.add(f);
        }

        for (int i: pq)sum+=i;

        return sum;
    }
}
