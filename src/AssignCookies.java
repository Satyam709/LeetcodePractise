import java.util.Arrays;

public class AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;

        for (int i = 0 ,cookie = 0; i < g.length && cookie<s.length; ) {

            int cmp = g[i] - s[cookie];

            if (cmp >= 0) {
                count++;
                i++;
            }
            cookie++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] g = {1,2};
        int[] s = {1,2,3};

        System.out.println(findContentChildren(g,s));
    }
}
