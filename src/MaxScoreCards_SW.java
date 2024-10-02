public class MaxScoreCards_SW {
    public int maxScore(int[] cardPoints, int k) {

        int size = cardPoints.length;
        int l = size - k, r = l;

        int sum = 0;
        int max = 0;

        boolean isWindowFixed = false ,isSizeReached = false;

        while (true) {

            if (isSizeReached && r == k)break;

            if (r==size)
                isSizeReached = true;

            r%=size;

            System.out.println("l="+l);
            System.out.println("r="+r);

            sum += cardPoints[r];

            System.out.println(sum);

            if (isWindowFixed) {
                sum -= cardPoints[l];
                l++;
            }

            max = Math.max(sum, max);

            if (r == size - 1)
                isWindowFixed = true;

            r++;

        }

        return max;
    }

    public static void main(String[] args) {

        MaxScoreCards_SW obj = new MaxScoreCards_SW();

        int[] cardPoints = {2,2,2};
        int k = 2;

        System.out.println(obj.maxScore(cardPoints,k));

    }

}
