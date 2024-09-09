import java.util.Arrays;

public class Spiral1V {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {

        int left = 0, right = n - 1, up = 0, down = m - 1;

        int[][] spiral = new int[m][n];

        int i = 0;


        for (int j = 0; j < m; j++) {
            Arrays.fill(spiral[j], -1);
        }

        ListNode crnt = head;
        boolean isEmpty = false;
        outer:
        while (true) {

            for (int j = left; j <= right; j++) {

                spiral[up][j] = crnt.val;
                crnt = crnt.next;
                if (crnt == null) {
                    break outer;
                }
            }
            up++;

            for (int j = up; j <= down; j++) {

                spiral[j][right] = crnt.val;
                crnt = crnt.next;
                if (crnt == null) {
                    break outer;
                }
            }
            right--;

            for (int j = right; j >= left; j--) {

                spiral[down][j] = crnt.val;
                crnt = crnt.next;
                if (crnt == null) {
                    break outer;
                }
            }
            down--;

            for (int j = down; j >= up; j--) {

                spiral[j][left] = crnt.val;
                crnt = crnt.next;
                if (crnt == null) {
                    break outer;
                }
            }
            left++;
        }
        return spiral;
    }
}
