import java.util.Arrays;
import java.util.PriorityQueue;

public class LongestHappyString {
    private static class Freq implements Comparable<Freq> {
        char c;
        int f;

        Freq(char c, int f) {
            this.c = c;
            this.f = f;
        }

        @Override
        public int compareTo(Freq o) {
            return Integer.compare(o.f, this.f);
        }

        @Override
        public String toString() {
            return c + "=" + f;
        }
    }

    public static String longestDiverseString(int a, int b, int c) {
        char[] out = new char[301];
        int j = -1;
        PriorityQueue<Freq> pq = new PriorityQueue<>(3);

        pq.add(new Freq('a', a));
        pq.add(new Freq('b', b));
        pq.add(new Freq('c', c));

        Freq prev = pq.poll(), tmp = null;
        while (prev != null) {

            int rem = Math.min(2, prev.f);
            char ch = prev.c;
            for (int i = 0; i < rem; i++) {
                out[++j] = ch;
            }
            prev.f -= rem;
            tmp = prev;
            prev = pq.poll();
            assert prev != null;
            prev = prev.f > 0 ? prev : null;
            System.out.println(prev);
            pq.add(tmp);
        }
        int i = 1;
        int l = j;
        System.out.println(tmp);
        while (tmp!=null && tmp.f > 0 && i < l - 1) {
            for (; i < l-1; i++) {
                if (out[i] != tmp.c && out[i + 1] != tmp.c)
                    break;
            }
            char tmpChar = out[i];
            out[i] = ' ';
            out[++j] = tmpChar;
            if (tmpChar==tmp.c)break;
            int rem = Math.min(2, tmp.f);
            for (int k = 0; k < rem; k++) {
                out[++j] = tmp.c;
            }
            tmp.f -= rem;
            i++;
        }
        System.out.println(Arrays.toString(out));
        StringBuilder bi = new StringBuilder(a + b + c);
        for (int k = 0; k <= j; k++) {
            if (Character.isAlphabetic(out[k]))
                bi.append(out[k]);
        }
        return bi.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestDiverseString(0, 8, 13));
    }
}
