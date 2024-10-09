import java.util.Arrays;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        // Sort intervals by the starting value
        Arrays.sort(intervals, (i, j) -> {
            if (i[0] != j[0]) {
                return i[0] - j[0];
            }
            return i[1] - j[1];
        });

        System.out.println("Sorted Array: " + Arrays.deepToString(intervals));

        int[][] out = new int[intervals.length][2];
        int j = 0;
        out[j] = intervals[0]; // Initialize with the first interval

        for (int i = 1; i < intervals.length; i++) {
            // If the current interval overlaps with the previous one, merge them
            if (intervals[i][0] <= out[j][1]) {
                out[j][1] = Math.max(out[j][1], intervals[i][1]); // Extend the end time
            } else {
                // Move to the next interval
                j++;
                out[j] = intervals[i];
            }
        }

        // Return only the relevant part of the output array
        return Arrays.copyOf(out, j + 1);
    }

    public static void main(String[] args) {
        int[][] a = {{15, 18}, {2, 6}, {1, 3}, {8, 10}};

        System.out.println(Arrays.deepToString(merge(a)));


    }
}
