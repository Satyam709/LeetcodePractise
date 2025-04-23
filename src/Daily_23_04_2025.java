import java.util.HashMap;
import java.util.Map;

public class Daily_23_04_2025 {
    public static int countLargestGroup(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();

        int max = -1;
        for (int i = 1; i <=n ; i++) {
            int t =i;
            int sum = 0;
            while (t>0){
                sum += t%10;
                t/=10;
            }
            int v = map.getOrDefault(sum,0);
            map.put(sum,v+1);
            max = Math.max(v+1 , max);
        }

        int finalMax = max;
        return (int)map.values()
                .stream()
                .filter(it->it == finalMax)
                .count();
    }
    public static void main(String[] args) {
        System.out.println(countLargestGroup(13));
    }
}
