import java.util.List;

public class SubTree {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    private boolean isFound = false;

    public boolean isSubPath(ListNode head, TreeNode root) {
        traverse(root,head,head);
        return isFound;
    }

    private void traverse(TreeNode root,ListNode fixedHead,ListNode head){

//        if (head == null)
//            isFound = true;

        if (root == null || isFound) return;

        int val = root.val;

        if (val == head.val){

            if (head.next == null)isFound = true;

            if (root.left!=null && head.val == root.left.val)
            {
                traverse(root.left,fixedHead,head.next);
                traverse(root.right,fixedHead,head.next);
            }
            else if (root.right!=null && head.val == root.right.val){
                traverse(root.right,fixedHead,head.next);
                traverse(root.left,fixedHead,head.next);
            }
            else{
                traverse(root.right,fixedHead,fixedHead);
                traverse(root.left,fixedHead,fixedHead);
            }

        }
        else{
            traverse(root.right,fixedHead,fixedHead);
            traverse(root.left,fixedHead,fixedHead);
        }
    }

    private void traverse2(TreeNode root,ListNode fixedHead,ListNode head){

        if (head == null)
            isFound = true;

        if (root == null || isFound) return;

        int val = root.val;

        if (val == head.val){
            traverse2(root.left,fixedHead,head.next);
            traverse2(root.right,fixedHead,head.next);
        }
        else if (val == fixedHead.val){
            traverse2(root.left,fixedHead.next,head);
            traverse2(root.right,fixedHead.next,head);
        }
        else{
            traverse(root.right,fixedHead,fixedHead);
            traverse(root.left,fixedHead,fixedHead);
        }
    }

}
