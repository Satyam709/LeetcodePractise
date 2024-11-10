public class MinimumArrayEnd {
    public static long minEnd(int n, int x) {
        int lastNo = x;
        int c =1 ;
        while (c<n){
            lastNo++;
            if ((lastNo&x) == x)
                c++;
        }
        return lastNo;
    }


    public static void main(String[] args) {
        System.out.println(minEnd(3,4));
    }
}
