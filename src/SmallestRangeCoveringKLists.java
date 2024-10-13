import java.util.*;

public class SmallestRangeCoveringKLists {
    private static class IdxVal implements Comparable<IdxVal> {
        int val;
        int listNo;

        IdxVal(int val, int listNo) {
            this.val = val;
            this.listNo = listNo;
        }

        @Override
        public int compareTo(IdxVal o) {
            return Integer.compare(this.val, o.val);
        }

        @Override
        public String toString() {
            return "("+val+","+listNo+") ";
        }
    }

    public static int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        HashMap<Integer, Iterator<Integer>> map = new HashMap<>(k);

        PriorityQueue<IdxVal> pq = new PriorityQueue<>();
        int idx = 0;

        int max;
        for (List<Integer> li : nums) {
            map.put(idx, li.iterator());
            int crnt = map.get(idx).next();
            //max = Math.max(crnt, max);
            pq.add(new IdxVal(crnt, idx));
            idx++;
        }

        System.out.println(map);
        //System.out.println(pq);

        int lw = Integer.MAX_VALUE;
        int up = Integer.MIN_VALUE;
        int diff = Integer.MAX_VALUE;

        boolean isAnyEmpty = false;
        while (!isAnyEmpty) {

            if (pq.isEmpty())
                break;
            System.out.println(pq);
            IdxVal minList = pq.peek();
            max = getCrntMax(pq);

            int val = minList.val;
            int listNo;
            System.out.println("comparing "+val);
            while (!pq.isEmpty() && pq.peek().val == minList.val) {
                listNo = pq.poll().listNo;
                Iterator<Integer> it = map.get(listNo);

                if (!it.hasNext()) {
                    System.out.println("one list over");
                    isAnyEmpty = true;
                    break;
                } else {
                    int tmp = it.next();
                    IdxVal tmpIdx = new IdxVal(tmp, listNo);
                    System.out.println("adding "+tmpIdx);
                    pq.add(tmpIdx);
                }
            }

            if (max-val<diff){
                diff = max-val;
                lw = val;
                up=max;
            }
            System.out.println("current situation = "+lw+" to "+ up);
        }
        return new int[]{lw,up,diff};
    }

    private static int getCrntMax(PriorityQueue<IdxVal> q) {
        IdxVal max = new IdxVal(Integer.MIN_VALUE, -1);
        for (IdxVal v : q) {
            max = v.val > max.val ? v : max;
        }
        return max.val;
    }


    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();

        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0, 9, 12, 20));
        nums.add(Arrays.asList(5, 18, 22, 30));

        List<List<Integer>> nestedList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 2, 3)
        );

        // Output the lists
        System.out.println(nums);

        System.out.println(Arrays.toString(smallestRange(nums)));
        System.out.println();
        System.out.println(Arrays.toString(smallestRange(nestedList)));
    }
}
