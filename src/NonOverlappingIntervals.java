import java.util.Arrays;

public class NonOverlappingIntervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        int removal = 0;

        Arrays.sort(intervals,(i,j)->{
            return Integer.compare(i[1],j[1]);
        });
        int last = 0;
        System.out.println(Arrays.deepToString(intervals));

        for (int i = 1; i < intervals.length; i++) {
            // take the first ignore the rest


            if(intervals[last][1] > intervals[i][0]){
                removal++;
            }
            else last = i;
        }

        return removal;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,100},{11,22},{1,11},{2,12}};
        System.out.println(eraseOverlapIntervals(intervals));
    }
}
