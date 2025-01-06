import java.util.Arrays;

public class MinOperationsToMove {
    public static int[] minOperations(String boxes) {
        int[] op = new int[boxes.length()];
        int leftOnes = 0, rightOnes = 0;
        int leftCost = 0 ,rightCost = 0;

        for (int i = 1, j = boxes.length() - 2; i < boxes.length(); i++, j--) {
            if (boxes.charAt(i - 1) == '1') {
                leftOnes++;
            }
            if (boxes.charAt(j + 1) == '1') {
                rightOnes++;
            }
            leftCost += leftOnes;
            rightCost += rightOnes;
            op[i] += leftCost;
            op[j] += rightCost;
        }
//        System.out.println(Arrays.toString(op));
        return op;
    }

    public static void main(String[] args) {
        String boxes = "001011";
        System.out.println(Arrays.toString(minOperations(boxes)));
    }
}
