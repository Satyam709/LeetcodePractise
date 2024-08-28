import java.util.Arrays;

public class ClosestPlaindrome {
    public String nearestPalindromic(String n) {
        return nxtSameLengthPal(n);
    }

    private String nxtSameLengthPal(String n) {

        int f = 0, r = n.length() - 1;
        char[] ch = n.toCharArray();
        boolean isPalindrome = true;

        while (f < r) {
            int fe = Integer.parseInt("" + ch[f]);
            int re = Integer.parseInt("" + ch[r]);

            if (fe != re) {
                ch[r] = (char) (fe + '0');
                isPalindrome = false;
                System.out.println(Arrays.toString(ch));
            }
            f++;
            r--;
        }
        // System.out.println(Arrays.toString(ch));
        if (isPalindrome) {
            int fe = Integer.parseInt("" + ch[f]);

            if (fe == 0)
                fe++;
            else
                fe--;

            if (f == r) {
                ch[r] = (char) (fe + '0');
            } else {
                ch[r] = (char) (fe + '0');
                ch[f] = (char) (fe + '0');
            }
        }
        return new String(ch);
    }


    private boolean isPalindrome(String n) {
        int f = 0, r = n.length() - 1;

        while (f < r) {
            if (n.charAt(f++) != n.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    private void minPaliCheck(String s) {

    }

//    //string s1 - s2
//    private int diff(String s1, String s2) {
//        if (s1.length() < s2.length() || s1.charAt(0) < s2.charAt(0)) {
//            return -1 * diff(s2, s1);
//        } else {
//            int diff = 0;
//            for (int i = s1.length() - 1; i >= 0; i--) {
//                int pow = Math.pow()
//                diff
//            }
//        }
//    }


    public static void main(String[] args) {


        System.out.println("123".compareTo("212"));


        String n = "11";
        ClosestPlaindrome obj = new ClosestPlaindrome();
        String out1 = obj.nearestPalindromic(n);
        System.out.println("isPAli = " + obj.isPalindrome(n));
        int a = Integer.parseInt(out1);
        int bn = Integer.parseInt(n);
        int d1 = a - bn;
        System.out.println("out1 " + out1 + " diff = " + d1);

        if (d1 > 0) {
            String s2 = "" + (bn - d1);
            if (obj.isPalindrome(s2)) {
                out1 = s2;
            } else {
                String out2 = obj.nearestPalindromic(s2);
                int d2 = Integer.parseInt(out2) - Integer.parseInt(n);
                if (d2 < d1)
                    out1 = out2;
            }
        }
        System.out.println(out1);
    }

}
