public class BalanceStr {
    public static int minSwaps(String s) {
        int l = 0, r = s.length() - 1;
        char[] ch = s.toCharArray();
        int lc = 0, rc = 0;
        int minCount = 0;

        while (l < r) {

            while (l<r && lc >= 0) {
                if (ch[l] == ']')
                    lc--;
                else lc++;
                if (lc >= 0) l++;
            }

            while (r>l && rc >= 0) {
                if (ch[r] == '[')
                    rc--;
                else rc++;
                if (rc >= 0) r--;
            }

            if (l < r) {
                swap(ch, l, r);
                lc = 0;
                rc=0;
                minCount++;
            }

        }
        return minCount;
    }

    private static void swap(char[] ch, int i, int j) {
        System.out.println("swapped " + ch[i] + " with " + ch[j]);
        char t = ch[i];
        ch[i] = ch[j];
        ch[j] = t;
    }

    public static void main(String[] args) {
        String s = "][][";
        System.out.println(minSwaps(s));
    }
}
