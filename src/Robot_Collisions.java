import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Robot_Collisions {

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < positions.length; i++) {
            map.put(positions[i], i);
        }
        Arrays.sort(positions);
        System.out.println(Arrays.toString(positions));

        while (true) {
            int leftTmp = -1;
            int rightTmp = -1;

            for (int i = 0; i < positions.length; i++) {
                if (positions[i] == -1) continue;

                System.out.println(directions.charAt(map.get(positions[i])));
                if (directions.charAt(map.get(positions[i])) == 'L') {
                    if (leftTmp!=-1) {
                        rightTmp = i;
                        break;
                    }
                } else {
                    System.out.println("hello");
                    leftTmp = i;
                }
            }

            System.out.println(leftTmp);
            System.out.println(rightTmp);
            if (leftTmp == -1 || rightTmp == -1) break;

            int left = map.get(positions[leftTmp]);
            int right = map.get(positions[rightTmp]);

            if (healths[left] > healths[right]) {
                healths[left]--;
                healths[right] = -1;

                positions[rightTmp] = -1;
            } else if (healths[left] < healths[right]) {
                healths[right]--;
                healths[left] = -1;

                positions[leftTmp] = -1;
            } else {
                healths[left] = -1;
                healths[right] = -1;

                positions[rightTmp] = -1;
                positions[leftTmp] = -1;
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

        int[] p = {3,40};
        int[] h = {49,11};
        String d = "LL";

//        int[] p = {3,5,2,6};
//        int[] h = {10,10,15,12};
//        String d = "RLRL";

        Robot_Collisions obj = new Robot_Collisions();
        System.out.println(obj.survivedRobotsHealths(p, h, d));


    }
}