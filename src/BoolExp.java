import java.util.Stack;

public class BoolExp {
    public static boolean parseBoolExpr(String expression) {
        boolean and,or;
        Stack<Character> stk = new Stack<>();

        //!(&(!(&(f)),&(t),|(f,f,t)))"

        for (int i = 0; i < expression.length(); i++) {
           char ch = expression.charAt(i);

            if (!stk.isEmpty() && ch == ')'){
                or =false;
                and =true;
                char poped = 't';

              while (!stk.isEmpty() && stk.peek()!='('){
                   poped= stk.pop();
                  if (poped == 't'){
                      or = true;
                  }
                  else if (poped == 'f'){
                      and = false;
                  }
                  //System.out.println("operation done -> "+stk);
              }
              //rem opening parenthesis
              stk.pop();

              char tmpc = stk.peek();
                //System.out.println("lets perform "+tmpc);
                //System.out.println("and = "+and);
                //System.out.println("or = "+or);
              if (tmpc == '&'){
                  stk.pop();
                  stk.push(and?'t':'f');

              }
              else if (tmpc == '|'){
                  stk.pop();
                  stk.push(or?'t':'f');

              }
              else if (tmpc == '!'){
                  stk.pop();
                  stk.push(poped == 't'?'f':'t');

              }

            }
            else {
                stk.push(ch);
            }
            //System.out.println("Crnt stk at end of "+i+" -> "+stk);
        }

        return stk.peek() == 't';
    }

    public static void main(String[] args) {
//        System.out.println(parseBoolExpr("&(|(f))"));
//        System.out.println(parseBoolExpr("(|(t,f,!(&(|(f)))))"));
//        System.out.println(parseBoolExpr("|(f,f,f,t)"));
//        //System.out.println(parseBoolExpr("!(&(f,t))"));
//
//
//        //System.out.println(parseBoolExpr("|(&(t,f,t),!(t))"));

        //System.out.println(parseBoolExpr("!(&(!(&(f)),&(t),|(f,f,t)))"));
    }
}
