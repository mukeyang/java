package leetcode;

/**
 * Created by CS on 2017/10/25.
 */
public class _2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p=l1,q=l2,cur=head;
        int flag=0;
        while (q != null || q != null) {
            int x = (p == null) ? p.val : 0;
            int y = (q == null) ? q.val : 0;
            int val=x+y+flag;
            flag=val/10;
            cur.next = new ListNode(val % 10);
            cur = cur.next;
            if (q != null) {
                q = q.next;
            }
            if (p!=null) p=p.next;

        }
        if (flag > 0) {
            cur.next = new ListNode(flag);
        }
        return head.next;
    }
}
class ListNode {
      int val;
     ListNode next;
      ListNode(int x) { val = x; }
  }