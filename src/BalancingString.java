import java.util.Stack;

public class BalancingString {
    public int minimumDeletions(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        int bBefore = 0;
        char firstCh = s.charAt(0);
        boolean hasToPush = false;
        int aAhead = aAhead(s);
        for (int i = 0; i < s.length(); i++) {
            char cc = s.charAt(i);
            if (cc == 'a') aAhead--;

            // logic
//            if (stack.isEmpty() || stack.peek() == firstCh){
//
//            }
            if (cc != firstCh || hasToPush) {
                stack.push(cc);
                firstCh = cc;
            }
            //
            if (cc == 'b') bBefore++;
        }
        return count;
    }

    private int aAhead(String s) {
        int ca = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == 'a') ca++;
        }
        return ca;
    }

    public static void main(String[] args) {
        String s = "aababbab";

        BalancingString obj = new BalancingString();
        System.out.println(obj.minimumDeletions(s));
    }
}

