import java.util.Stack;

public class SubStrCut {
    public static int minLength(String s) {
        int l = s.length();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'B' || ch == 'D') {
                char oth = 'C';
                if (ch == 'B') oth = 'A';
                if (!stack.isEmpty()) {
                    char tmp = stack.peek();
                    if (tmp == oth) {
                        stack.pop();
                        l -= 2;
                        continue;
                    }
                }
            }
                stack.push(ch);
        }
        return l;
    }

    public static void main(String[] args) {
        String s = "ACBBD";
        System.out.println(minLength(s));
    }
}
