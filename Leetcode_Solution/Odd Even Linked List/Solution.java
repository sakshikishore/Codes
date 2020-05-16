/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode p=head;
        if(p!=null)
        {
        ListNode q=head.next;
        
        ListNode r=q;
        ListNode t=r;
        while(p!=null && p.next!=null)
        {
            p.next=q.next;
            p=p.next;
            if(p!=null)
            {
            q=p.next;
            r.next=q;
            r=q;
            }
        }
        ListNode z=head;
        while(z.next!=null)
        {
            z=z.next;
        }
        z.next=t;
        }
        return head;
        
    }
}
