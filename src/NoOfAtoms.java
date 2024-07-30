import java.util.HashMap;
import java.util.Stack;

public class NoOfAtoms {

    public String countOfAtoms(String formula) {
        Stack<Character> stack = new Stack<>();
        HashMap<String, Integer> atoms = new HashMap<>();

        for (int i = 0; i < formula.length(); i++) {
            char ch = formula.charAt(i);
            if (Character.isUpperCase(ch)) {
                String atomName = "";
                while (Character.isLowerCase(formula.charAt(++i))) {
                    atomName = atomName + formula.charAt(i);
                }

                String atomNo = "";
                while (Character.isDigit(formula.charAt(++i))) {
                    atomNo = atomNo + formula.charAt(i);
                }
                if (atomNo.isEmpty())
                    atomNo = "1";
                atoms.put(atomName, Integer.parseInt(atomNo));

                i--;
                continue;
            } else if (ch == '(') {
                do {
                    stack.push(formula.charAt(i));
                    if (formula.charAt(i)==')'){
                        while (true){
                            char chw = stack.pop();
                            if (chw == '(')break;

                        }
                    }
                } while (!stack.isEmpty());

            }
        }


        return null;
    }

    public static void main(String[] args) {

    }
}
