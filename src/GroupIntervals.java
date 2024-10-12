import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GroupIntervals {
    public static int minGroups(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>(n);

        for (int[] interval : intervals) {
            if (!pq.isEmpty() && pq.peek() < interval[0]) {
                pq.poll();
            }
            pq.add(interval[1]);
        }
        return pq.size();
    }

    public static void main(String[] args) {
        int[][] intervals = {{441459, 446342}, {801308, 840640}, {871890, 963447}, {228525, 336985}, {807945, 946787}, {479815, 507766}, {693292, 944029}, {751962, 821744}};
        System.out.println(minGroups(intervals));
    }
}
