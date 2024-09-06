import java.util.HashMap;
import java.util.HashSet;

public class DeleteNodes {

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

    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int i : nums)
            set.add(i);

        ListNode temp = head;

        while (temp!=null && set.contains(temp.val)){
            temp = temp.next;
        }

        head = temp;

        if(temp == null)
            return head;

        while(temp.next!=null){
            if (set.contains(temp.next.val)){
                temp.next = temp.next.next;
            }
            else
                temp = temp.next;
        }

        return head;
    }

}
