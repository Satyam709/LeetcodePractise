import java.util.Stack;

public class MaxOrSequences {
    public static int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for (int num : nums) {
            maxOr = num | maxOr;
        }
        System.out.println(maxOr);
        Stack<Integer> out = new Stack<>();
        out.push(0);
        return getCombinations(out,0,nums,maxOr);
    }

    private static int getCombinations(Stack<Integer> stk, int i, int[] arr, int maxOr) {
        //System.out.println("stk = "+stk);
        int crntOr = stk.pop();
        //System.out.println(crntOr+ " i = "+i);

        int gotCombis = 0;
        if (i >= arr.length || crntOr>maxOr) {
            if (crntOr == maxOr) {
                System.out.println(stk);
                gotCombis = 1;
            }
            stk.push(crntOr);
            return gotCombis;
        }
        // add i with modeifed or
        stk.push(arr[i]);
        stk.push(arr[i] | crntOr);
        gotCombis += getCombinations(stk,i+1,arr,maxOr);
        // rem it
        if (!stk.isEmpty()){
            stk.pop();
            stk.pop();
        }
        stk.push(crntOr);
        gotCombis +=getCombinations(stk,i+1,arr,maxOr);

        return gotCombis;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5};
        System.out.println(countMaxOrSubsets(arr));
    }
}
