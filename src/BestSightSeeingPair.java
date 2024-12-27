public class BestSightSeeingPair {
    public static int maxScoreSightseeingPair(int[] values) {
        int max = 1;
        int limits = Math.min(2001, values.length);
        // vary d from 1 to limits;
        for (int d = 1; d < limits; d++) {
            System.out.println("dis = "+d);
            for (int i = 0; i < values.length - d; i++) {
                System.out.println("compapring i="+i+" j="+(i+d));
                max = Math.max(values[i] + values[i + d] - d, max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] values = {8,1,5,2,6};
        System.out.println(maxScoreSightseeingPair(values));
    }
}
