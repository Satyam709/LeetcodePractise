public class Daily_18_03_2025 {
    public static int longestNiceSubarray(int[] arr) {
        int l = 0;
        int c = 1;
        int maxl = 1;
        long preOr = arr[0];
        for (int r = 1; r < arr.length; r++) {
            if ((arr[r] & preOr) == 0) {
                preOr |= arr[r];
                c++;
                maxl = Math.max(maxl, c);
                continue;
            }
            maxl = Math.max(maxl, c);
            c = 1;
            l = r;
            preOr = 0;
            while (l > 0 && (arr[r] & (preOr | arr[l - 1])) == 0) {
                l--;
                c++;
                preOr |= arr[l];
            }
            preOr |= arr[r];
        }
        return Math.max(maxl, c);
    }

    public static void main(String[] args) {
        int[] nums = {135745088, 609245787, 16, 2048, 2097152};
        System.out.println(longestNiceSubarray(nums));
    }
}
