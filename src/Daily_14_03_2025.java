public class Daily_14_03_2025 {
    public static int maximumCandies(int[] candies, long k) {
        int lw = 0 , up = (int)1e7 +1;
        int lastValid = 0;
        while(lw<=up){
            int mid = (lw + up)/2;
            if (isValid(mid,candies,k)){
                lw = mid + 1;
                lastValid = mid;
            }
            else{
                up = mid -1;
            }
        }
        return lastValid;
    }

    private static boolean isValid(int x , int[] arr ,long k){
        if (x <= 0 )return true;
        long count = 0 ;
        for (int j : arr) {
            count += j / x;
        }
        return count>=k;
    }

    public static void main(String[] args) {
        int[] candies = {5,8,6};
        int k = 3;
        System.out.println(maximumCandies(candies,k));
    }
}
