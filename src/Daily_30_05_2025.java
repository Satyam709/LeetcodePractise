import java.util.Arrays;

public class Daily_30_05_2025 {
    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dis1 = getDis(edges, node1);
        int[] dis2 = getDis(edges, node2);

        int minDis = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < edges.length; i++) {
            int newD = Math.max(dis1[i], dis2[i]);
            if (newD < minDis) {
                minDis = newD;
                minIdx = i;
            }
        }
        return minIdx;
    }

    private static int[] getDis(int[] edges, int n) {
        int[] distTo = new int[edges.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[n] = 0;

        int d = 0;
        while (true) {
            int child = edges[n];
            if (child < 0) break;
            if (distTo[child] != Integer.MAX_VALUE) break;
            distTo[child] = ++d;
            n = child;
        }
        return distTo;
    }


    public static void main(String[] args) {
        int[] edges = {2, 2, 3, -1};
        int node1 = 0, node2 = 1;
        System.out.println(closestMeetingNode(edges, node1, node2));
    }
}
