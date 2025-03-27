import java.util.*;

public class Daily_27_03_2025 {

    static record Freq(int a, int f) implements Comparable<Freq> {
        @Override
        public boolean equals(Object obj) {
            obj = (Freq) obj;
            return this.a == ((Freq) obj).a;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(this.a);
        }

        @Override
        public int compareTo(Freq o) {
            return Integer.compare(this.f, o.f);
        }
    }


    public static int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int[] arr = new int[n];
        int t = 0;
        for (int i : nums) {
            arr[t++] = i;
        }

        int[] pre = assignPre(arr);

        int[] post = revArray(assignPre(revArray(arr)));

        System.out.println("Pre : "+ Arrays.toString(pre));
        System.out.println("post : "+Arrays.toString(post));
        for (int i = 0; i < n-1; i++) {
            if (pre[i] == post[i+1] && pre[i] != -1)return i;
        }
        return -1;
    }

    private static int[] revArray(int[] arr) {
        int n = arr.length;
        int[] revArr = new int[n];
        for (int i = 0; i < n; i++) {
            revArr[i] = arr[n - i - 1];
        }
        return revArr;
    }


    private static int[] assignPre(int[] arr) {
        int n = arr.length;
        int[] pre = new int[n];

        HashMap<Integer, Integer> map = new HashMap<>();

        PriorityQueue<Freq> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            int crnt = arr[i];
            Integer prevfreq = map.get(crnt);
            if (prevfreq == null) {
                map.put(crnt, 1);
                pq.add(new Freq(crnt, 1));
            } else {
                boolean last = pq.remove(new Freq(crnt,0));
                pq.add(new Freq(crnt, prevfreq + 1));
                map.put(crnt,prevfreq+1);
            }
            System.out.println("pq at i = "+i+ " is "+pq);
            Freq top = pq.peek();

            assert top != null;
            pre[i] = (top.f > ((i + 1) / 2)) ? top.a : -1;
        }
        return pre;
    }


    public static void main(String[] args) {
        int[] nums = {3,3,3,3,7,2,2};
        System.out.println(minimumIndex(Arrays.stream(nums)
                .boxed()
                .toList()));
    }
}
