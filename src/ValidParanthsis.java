public class ValidParanthsis {
    public boolean checkValidString(String s) {

        int lw = 0,up = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                lw++;
                up++;
            }
            else if (ch == ')') {
                lw = Math.max(0,lw-1);
                up--;
            }
            else {
                lw = Math.max(0,lw-1);
                up++;
            }

            if (up <0)return false;

        }
        return lw == 0;
    }
}
