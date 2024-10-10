import java.util.Stack;

public class SortStack {

    public static Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        for (int i = 1; i <= s.size(); i++)
            stacksort(s, Integer.MIN_VALUE, i);
        return s;
    }

    private static int stacksort(Stack<Integer> stack, int crntmax, int i) {
        if (stack.size() < i) {
            stack.push(crntmax);
            return crntmax;
        }

        int t = stack.pop();
        crntmax = Math.max(t, crntmax);

        int finalMax = stacksort(stack, crntmax, i);

        if (t != finalMax)
            stack.push(t);
        else finalMax=Integer.MIN_VALUE;
        return finalMax;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        int[] a = {3,2,1};
        for (int i : a) s.push(i);

        for (int i = 0; i < 999; i++) {
            s.push(i);
        }
        sort(s);
        System.out.println(s);
    }
}
