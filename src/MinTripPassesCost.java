import java.util.Arrays;

public class MinTripPassesCost {
    public static int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        dp[days[0]] = costs[0];
        for (int i = 1; i < days.length; i++) {
            int day = days[i];
            int p1 = Integer.MAX_VALUE;
            int p3 = p1, p2 = p1;

            // 1 day pass

            int lpd1 = getPresentDay(day - 1, days);
            System.out.println("ldp1 = "+lpd1);
            p1 = dp[lpd1] + costs[0];
            // 7 day pass
            int lpd2 = getPresentDay(day - 7, days);
            System.out.println("ldp2 = "+lpd2);
            p2 = dp[lpd2] + costs[1];
            // 30 day pass
            int lpd3 = Math.max(day - 30, 0);
            System.out.println("ldp3 = "+lpd3);
            p3 = dp[lpd3] + costs[2];

            dp[day] = Math.min(Math.min(p1, p2), p3);

            System.out.println(Arrays.toString(dp));
        }

        return dp[lastDay];
    }

    private static int getPresentDay(int day, int[] days) {
        for (int i = days.length - 1; i >= 0; i--) {
            if (day >= days[i]) return days[i];
        }
        return 0;
    }


    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};

        int[] days2 = {1, 3,7};
        int[] costs2 = {1,4,20};
        System.out.println(" out --> " + mincostTickets(days2, costs2));
    }
}
