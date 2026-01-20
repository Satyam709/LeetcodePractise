public class Daily_12_01_25 {
    public static boolean canBeValid(String s, String locked) {
        if (s.length() < 2) return false;

        if (s.charAt(0) == ')' && locked.charAt(0) == '1') return false;
        if (s.charAt(s.length() - 1) == '(' && locked.charAt(s.length() - 1) == '1') return false;

        int lw = 0, up = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            boolean isLocked = locked.charAt(i) == '1';
            if (isLocked) {
                if (ch == '(') {
                    lw++;
                    up++;
                } else {
                    lw = Math.max(0, lw - 1);
                    up--;
                }
            } else {
                lw = Math.max(0, lw - 1);
                up++;
            }
            if (up < 0) return false;
        }

        return lw == 0;
    }

    public static void main(String[] args) {
       String s = "))))", locked = "0101";
        System.out.println(canBeValid(s,locked));
    }
}
