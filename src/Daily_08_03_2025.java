public class Daily_08_03_2025 {
    public static int minimumRecolors(String blocks, int k) {
        int l = 0;
        int cb = 0;
        int maxcb = 0;
        for (int r = 0; r < blocks.length(); r++) {
            if (blocks.charAt(r) == 'B') cb++;
            if (r - l + 1 < k) continue;
            maxcb = Math.max(maxcb, cb);
            if (blocks.charAt(l++) == 'B') cb--;
        }
        return k - maxcb;
    }

    public static void main(String[] args) {
        String blocks = "WBBWWBBWBW";
        int k = 7;
        System.out.println(minimumRecolors(blocks,k));
    }
}
