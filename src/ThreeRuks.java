import java.util.*;

public class ThreeRuks {

    public static long maximumValueSum(int[][] board) {
        int cols = board[0].length;
        int rows = board.length;



        Map<Integer, List<Pair>> map = new HashMap<>(100);

        for (int i = 0; i < rows; i++) {
            int[] ints = board[i];
            PriorityQueue<Pair> pq = new PriorityQueue<>(101);
            for (int k = 0; k < ints.length; k++) {
                pq.add(new Pair(ints[k], k));
            }
            List<Pair> li = new ArrayList<>(3);

            li.add(pq.poll());
            li.add(pq.poll());
            li.add(pq.poll());

            map.put(i, li);
        }
        long sum = Long.MIN_VALUE;

        for (int i = 0; i < rows - 2; i++) {
            List<Pair> li = map.get(i);
            System.out.println(li);
            for (int j = i + 1; j < rows - 1; j++) {
                List<Pair> lj = map.get(j);
                System.out.println(lj);
                for (int k = j + 1; k < rows; k++) {
                    List<Pair> lk = map.get(k);
                    System.out.println(lk);
                    for (Pair ip : li) {
                        int icol = ip.col;
                        for (Pair ij : lj) {
                            int jcol = ij.col;
                            for (Pair ik : lk) {
                                int kcol = ik.col;
                                if (icol != jcol && jcol != kcol && icol != kcol) {
                                    System.out.println("got sum  = "+(ij.val + ik.val + ip.val)+"for i="+icol+" j="+jcol+" k="+kcol);
                                    sum = Math.max(sum, ij.val + ik.val + ip.val);
                                    System.out.println(sum);
                                }
                            }
                        }
                    }

                }
            }
        }

        return sum;
    }

    record Pair(long val, int col) implements Comparable<Pair> {
        @Override
        public int compareTo(Pair o) {
            return Long.compare(o.val,this.val);
        }
    }

    public static void main(String[] args) {
//        int[][] board = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] b2 = {{-95,-22,85,-57},{-4,10,80,68},{-20,-59,99,-97},{-25,-60,71,21}};
        int[][] board = {{-254181552,909083515,1978998817},{405927678,422106940,441895162},{860220524,-558157613,929273732}};
        System.out.println(maximumValueSum(b2));

    }
}
