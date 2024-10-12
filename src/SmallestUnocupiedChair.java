import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SmallestUnocupiedChair {

    private static class Friend implements Comparable<Friend> {
        int chair;
        int departure;

        Friend(int chair, int departure) {
            this.chair = chair;
            this.departure = departure;
        }

        @Override
        public int compareTo(Friend o) {
            return this.departure - o.departure;
        }
    }

    public static int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        PriorityQueue<Friend> pq = new PriorityQueue<>(n);
        PriorityQueue<Integer> polledChairs = new PriorityQueue<>(n);

        Integer[] indexes = new Integer[n];

        for (int i = 0; i < n; i++)
            indexes[i] = i;

        Arrays.sort(indexes, Comparator.comparingInt(i -> times[i][0]));

        int  maxchair = 0;

        for (int i = 0; i < times.length; i++) {

            while (!pq.isEmpty() && pq.peek().departure <= times[indexes[i]][0]) {
                polledChairs.add(pq.poll().chair);
            }

            int satChair = polledChairs.isEmpty() ? maxchair++:polledChairs.poll();

            pq.add(new Friend(satChair, times[indexes[i]][1]));

            if (indexes[i] == targetFriend) {
                return satChair;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] times = {{1,4},{2,3},{4,6}};
        int t = 1;
        System.out.println(smallestChair(times,t));
    }
}
