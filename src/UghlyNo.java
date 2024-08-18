import java.util.HashSet;
import java.util.PriorityQueue;

public class UghlyNo {

    public int nthUglyNumber(int n) {

        PriorityQueue<Long> pq = new PriorityQueue<>(10);
        HashSet<Long> marked = new HashSet<>(10);
        pq.add(1L);
        marked.add(1L);

        int count = 0;
        long num = 1;

        while (count != n) {

            num = Math.toIntExact(pq.poll());
            count++;

            if (!marked.contains(2 * num)) {
                pq.add(2 * num);
                marked.add(2 * num);
            }

            if (!marked.contains(3 * num)) {
                pq.add(3 * num);
                marked.add(3 * num);
            }

            if (!marked.contains(5 * num)) {
                pq.add(5 * num);
                marked.add(5 * num);
            }
        }
        return (int)num;
    }

    public static void main(String[] args) {
        int s = 1690;
        UghlyNo obj = new UghlyNo();
        System.out.println(obj.nthUglyNumber(s));
    }
}
