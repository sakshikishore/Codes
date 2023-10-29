/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
           if(head==null || head.next==null)
        {
            return head;
        }
        ListNode p=head,q=head.next;
        while(q!=null)
        {
            if(p.val==q.val)
            {
                q=q.next;
                p.next=null;
                p.next=q;
            }
            else
            {
                q=q.next;
                p=p.next;
            }
        }

        return head;
    }
}
