import java.util.Arrays;

public class Candy {
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        boolean isChanged = true;
        while (isChanged) {
            isChanged = false;

            for (int i = 0; i < n; i++) {

                // check left neighbour
                if (i > 0 && ratings[i] > ratings[i - 1] && !(candies[i] > candies[i - 1])) {
                    candies[i] = candies[i - 1] + 1;
                    isChanged = true;
                }
                // check right neighbour
                if (i < n - 1 && ratings[i] > ratings[i + 1] && !(candies[i] > candies[i + 1])) {
                    candies[i] = candies[i + 1] + 1;
                    isChanged = true;
                }
            }
            System.out.println(Arrays.toString(candies));
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
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
