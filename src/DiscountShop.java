import java.util.TreeSet;

public class DiscountShop {
    public int[] finalPrices(int[] prices) {

        for (int i = 0; i < prices.length; i++) {
            int dis = 0;
            for (int j = i+1; j < prices.length ; j++) {
                if (prices[j]>prices[i])continue;
                dis = prices[j];
                break;
            }
            prices[i]-=dis;
        }

        return prices;
    }
}
