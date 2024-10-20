public class NthBitInBinStr {
    public static char findKthBit(int n, int k) {
        char[] seq = new char[k];
        seq[0] = '0';
        int cp = 1;

        for (int i = 1; i < k; i++) {
            if (i == cp) {
                seq[i] = '1';
                cp--;
                continue;
            }
            seq[i] = seq[cp--] == '0' ? '1' : '0';
            if (cp<0)cp = i+1;
            //System.out.println(seq);
        }

        return seq[k - 1];
    }

    public static void main(String[] args) {
        System.out.println(findKthBit(4,15));
        System.out.println();
        System.out.println(findKthBit(3,1));
    }
}
