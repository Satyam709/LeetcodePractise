public class GcdInsertion {

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

    public ListNode insertGreatestCommonDivisors(ListNode head) {

        ListNode crnt = head;

        while (crnt.next!=null){
            ListNode nxt = crnt.next;
            crnt.next = new ListNode(gcd(crnt.val, nxt.val),nxt);
            crnt = crnt.next.next;
        }
        return head;
    }


    private static int gcd(int a, int b) {
        while (a % b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(gcd(45, 25));
    }

}
