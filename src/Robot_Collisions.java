import java.util.*;

public class Robot_Collisions {

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < positions.length; i++) {
            map.put(positions[i], i);
        }

        Stack<Integer> stack = new Stack<>();
        Arrays.sort(positions);
        int right = -1;
        int left = -1;

        int leftTmp = -1;

        for (int i = 0; i < positions.length; i++) {

            left = map.get(positions[i]);

            if (directions.charAt(left) == 'R') {
                stack.push(i);
            } else if (!stack.isEmpty()) {

                leftTmp = stack.peek();
                left = map.get(positions[leftTmp]);

                right = map.get(positions[i]);

                if (healths[left] > healths[right]) {
                    healths[left]--;
                    healths[right] = -1;
                } else if (healths[left] < healths[right]) {
                    healths[right]--;
                    healths[left] = -1;

                    i--;
                    stack.pop();
                } else {
                    healths[left] = -1;
                    healths[right] = -1;

                    stack.pop();
                }
            }
        }
        ArrayList<Integer> survivors = new ArrayList<>();
        for (int i : healths) {
            if (i != -1)
                survivors.add(i);
        }
        return survivors;
    }

    public static void main(String[] args) {

//        int[] p = {5,4,3,2,1};
//        int[] h = {2,17,9,15,10};
//        String d = "RRRRR";

//        int[] p = {3, 40};
//        int[] h = {49, 11};
//        String d = "LL";

//        int[] p = {3,5,2,6};
//        int[] h = {10,10,15,12};
//        String d = "RLRL";

        int[] p = {11,44,16};
        int[] h = {1,20,17};
        String d = "RLR";

        Robot_Collisions obj = new Robot_Collisions();
        System.out.println(obj.survivedRobotsHealths(p, h, d));


    }
}