import java.util.Arrays;

public class Candy {
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 1; i < n; i++) {
            // check left neighbour
            if (ratings[i] > ratings[i - 1] && !(candies[i] > candies[i - 1])) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        System.out.println("after left to right " + Arrays.toString(candies));
        for (int i = n - 2; i >= 0; i--) {
            // check left neighbour from end
            if (ratings[i] > ratings[i + 1] && !(candies[i] > candies[i + 1])) {
                candies[i] = candies[i + 1] + 1;
            }
        }
        System.out.println("after right to left " + Arrays.toString(candies));

        int sum = 0;
        for (int i = 0;i < n; i++) {
            sum += candies[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        int[] arr2 = {1, 2, 87, 87, 87, 2, 1};
        System.out.println(candy(arr));
        System.out.println(candy(arr2));
    }
}
