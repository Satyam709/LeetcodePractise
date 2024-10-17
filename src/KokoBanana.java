public class KokoBanana {
    public static int minEatingSpeed(int[] piles, int h) {
        if (h < piles.length) return -1;
        int lw = 1;
        int hi = getMax(piles), mid = -1;
        while (lw <= hi) {
            mid = lw + (hi - lw) / 2;
            int t = canEatAll(mid, piles);
            if (t <= h)
                hi = mid;
            else
                lw = mid + 1;
        }
        return lw;
    }

    private static int canEatAll(int k, int[] piles) {
        int cnt = 0;
        for (int i : piles)
            cnt += (int) Math.ceil(i / (1.0 * k));
        return cnt;
    }

    private static int getMax(int[] piles) {
        int max = 0;
        for (int i : piles)
            max = Math.max(i, max);
        return max;
    }

    public static void main(String[] args) {
        int[] piles = {1, 1, 1, 999999999};
        int h = 10;
        System.out.println();
        System.out.println(getMax(piles));
        //System.out.println(canEatAll(4,piles));
        System.out.println("out = " + minEatingSpeed(piles, h));
    }
}
