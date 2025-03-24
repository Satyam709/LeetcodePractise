import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Daily_24_03_2025 {
    public static int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a->a[0]));
        int count = 0 ;
        ArrayList<int[]> li = new ArrayList<>();
        int lw = meetings[0][0], up = meetings[0][1];
        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i][0]>up){
                li.add(new int[]{lw,up});
                lw = meetings[i][0];
                up = meetings[i][1];
            } else {
                up = Math.max(up,meetings[i][1]);
            }
        }
        li.add(new int[]{lw,up});
        System.out.println("original array "+ Arrays.deepToString(meetings));
        System.out.print("reworked array : ");
        for (int[] i : li){
            System.out.print(Arrays.toString(i) +" ");
        }
        System.out.println();
        for (int[] crntMeet : li) {
            int from = crntMeet[0], to = crntMeet[1];

            if (from > days) break;
            count += Math.min(to, days) - from + 1;
        }
        return days - count;
    }
    public static void main(String[] args) {
        int days = 5;
        int[][] meetings = {{2,4},{1,3}};

        System.out.println(countDays(days,meetings));
    }
}
