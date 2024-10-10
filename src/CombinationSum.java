import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> out = new ArrayList<>();
        getCombinationsSum(target, candidates, null, 0, out);
        return out;
    }

    private static void getCombinationsSum(int sum, int[] arr, Stack<Integer> crnt, int i, List<List<Integer>> out) {
        if (sum<0 || i>=arr.length)return;

        if (crnt == null){
            crnt =new Stack<>();
        }
        System.out.println("crnt stack at "+i +" is = "+crnt);
        if (sum == 0 && !crnt.isEmpty()) {
            System.out.println("hey found one");
            out.add(crnt.stream().toList());
            return;
        }

        crnt.push(arr[i]);
        getCombinationsSum(sum-arr[i],arr,crnt,i,out);
        // unpick at i
        crnt.pop();
        System.out.println("sum" + sum);
        getCombinationsSum(sum,arr,crnt,i+1,out);

    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates,target));
    }
}
