public class Daily_14_12_2025 {
    private static int MOD = (int) 1e9 + 7;

    public static int numberOfWays(String s) {
        int cc = 0, pp = 1;
        long ans = 1;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int ch = s.charAt(i);
            if (ch == 'S') {
                cc++;
                // for every third chair
                if (cc > 2) {
                    ans = (ans * pp) % MOD;
                    cc = 1;
                }
                pp = 1;
            }
            if (ch == 'P') {
                pp++;
            }
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        String corridor = "SSPPSPS";
        System.out.println(numberOfWays(corridor));
    }
}
