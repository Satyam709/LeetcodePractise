import java.util.HashMap;

public class MaxLengthSpecialString {
    public static int maximumLength(String s) {

        int max = -1;
        s = s+',';
        HashMap<String, Integer> map = new HashMap<>();
        int l = 0, r = 0;


        StringBuilder tmp = new StringBuilder(s.length());
        char last = '.';


        for (r = 0; r < s.length(); r++) {

            char ch = s.charAt(r);

            if (last != ch) {

                String sub  = tmp.toString();
                System.out.println("found substring "+ sub);
                int len = sub.length();

                for (int i = 1; i <= sub.length(); i++) {
                    String key = sub.substring(0,i);

                    int val = map.getOrDefault(key,0) + len--;
                    if (val>2){
                        max = Math.max(i,max);
                    }
                    System.out.println("key = "+key);
                    map.put(key,val);
                }
                tmp = new StringBuilder(s.length());
                System.out.println("updated map"+ map);
            }

            tmp.append(ch);
            last = ch;
            System.out.println("tmp at normal "+tmp);
        }



        return max;
    }

    public static void main(String[] args) {
        String s = "aaaa";

        System.out.println("out1 = "+maximumLength(s));
    }
}
