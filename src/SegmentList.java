public class SegmentList {

     public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] arr = new ListNode[k];
        ListNode t = head;
        int count =0 ;
        while (t!=null){
            count++;
            t=t.next;
        }

        int perBox = count/k;

        int rem = count%k;

        ListNode crnt = head;


        for (int i = 0; i < k; i++) {
            arr[i] = crnt;
            int toFill = perBox;
            if (rem>0) {
                toFill++;
                rem--;
            }
            for (int j = 0; j < toFill - 1 ; j++) {
                crnt = crnt.next;
            }
            if (crnt!=null){
                ListNode temp = crnt.next;
                crnt.next = null;
                crnt = temp;
            }
        }

        return arr;
    }
}
