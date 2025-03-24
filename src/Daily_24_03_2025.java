import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Daily_24_03_2025 {
    public static int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a->a[0]));
        int count = 0 ;
        int lw = meetings[0][0], up = meetings[0][1];
        for (int i = 1; i < meetings.length && lw <= days; i++) {
            if (meetings[i][0]>up){
                count += Math.min(up, days) - lw + 1;
                lw = meetings[i][0];
                up = meetings[i][1];
            } else {
                up = Math.max(up,meetings[i][1]);
            }
        }
        count += lw>days?0:Math.min(up, days) - lw + 1;
        return days - count;
    }
    public static void main(String[] args) {
        int days = 5;
        int[][] meetings = {{2,4},{1,3}};

        System.out.println(countDays(days,meetings));
    }
}
