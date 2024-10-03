import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FruitsBasketsSW {
    public static int totalFruits(int[] arr) {

        int l = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        int max = 0;
        for (int r = 0; r < arr.length; r++) {
            int f = arr[r];
            map.put(f,map.getOrDefault(f,0)+1);

            if (map.size() <= 2){
                max = Math.max(r - l + 1, max);
            } else {
                int tmp = map.get(arr[l])-1;
                if (tmp == 0)
                    map.remove(arr[l]);
                else map.put(arr[l],tmp);
                l++;
            }

        }
        return max;
        // code here
    }

    public static void main(String[] args) {
        int[]  arr = {85,12,69,8,34,53,72,60,29,48,32,66,19,27,6,27,44,44,60,80,22,73,65,8,62,81,41,20,76,12,6,65,45,1,90,84,74,32,90,44,27,79,91,21,36,82,70,8,83,59,39,20,70,15,5,28,29,54,51,34,51,1,71,56,15,29,68,8,68,51,7,72,70,6,9,39,21,2,22,18,36,79,10,84,29,8,42,22,1,42,62};
        System.out.println(totalFruits(arr));
    }
}
