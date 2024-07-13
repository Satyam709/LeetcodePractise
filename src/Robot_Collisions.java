import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Robot_Collisions {

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {


        List<Integer> survivors = new ArrayList<>(1);

        while (true) {
            int leftPosition = -1, rightPosition = -1;
            int leftIndex = -1, rightIndex = -1;

            for (int i = 0; i < positions.length; i++) {

                if (positions[i] == -1) continue;

                if (directions.charAt(i) == 'R') {
                    if (leftPosition == -1) {
                        leftPosition = positions[i];
                        leftIndex = i;
                    } else {
                        if (positions[i] == leftPosition + 1) {
                            leftPosition = positions[i];
                            leftIndex = i;
                        }
                    }
                } else {
                    if (rightPosition == -1) {
                        rightPosition = positions[i];
                        rightIndex = i;
                    } else {
                        if (positions[i] == leftPosition - 1) {
                            rightPosition = positions[i];
                            rightIndex = i;
                        }
                    }
                }
            }
            System.out.println("leftIndex = " + leftIndex);
            System.out.println("rightIndex = " + rightIndex);
            System.out.println("leftPosi = " + leftPosition);
            System.out.println("rightPosi = " + rightPosition);

            if (leftIndex == -1 || rightIndex == -1)
                break;

            if (leftIndex>rightIndex)
                break;

            int leftHealth = healths[leftIndex];
            int rightHealth = healths[rightIndex];

            if (leftHealth > rightHealth) {

                healths[leftIndex]--;
                positions[rightIndex] = -1;

                healths[rightIndex] = -1;

            } else if (leftHealth < rightHealth) {

                healths[rightIndex]--;
                positions[leftIndex] = -1;

                healths[leftIndex] = -1;

            } else {
                positions[leftIndex] = -1;
                positions[rightIndex] = -1;

                healths[leftIndex] = -1;
                healths[rightIndex] = -1;
            }
            System.out.println(Arrays.toString(positions));
            System.out.println(Arrays.toString(healths));
        }


        for (int i : healths) {
            if (i != -1) {
                survivors.add(i);
            }
        }
        return survivors;
    }

    public static void main(String[] args) {

//        int[] p = {5,4,3,2,1};
//        int[] h = {2,17,9,15,10};
//        String d = "RRRRR";

        int[] p = {3, 5, 2, 6};
        int[] h = {10, 10, 15, 12};
        String d = "RLRL";

//        int[] p = {3,5,2,6};
//        int[] h = {10,10,15,12};
//        String d = "RLRL";

        Robot_Collisions obj = new Robot_Collisions();
        System.out.println(obj.survivedRobotsHealths(p, h, d));


    }
}