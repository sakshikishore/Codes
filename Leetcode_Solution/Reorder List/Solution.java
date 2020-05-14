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
    public void reorderList(ListNode head) {
        if(head!=null)
        {
        ListNode p=head;
        ListNode q=head;
        ListNode r=null;
        while(p!=null && p.next!=null)
        {
            p=p.next.next;
            r=q;
            q=q.next;
        }
            if(r!=null)
            {
        r.next=null;
        // Reverse half Node
        ListNode prev=null;
        while(q!=null)
        {
            ListNode next=q.next;
            q.next=prev;
            prev=q;
            q=next;
        }
        
        ListNode L=head;
        ListNode t=prev;
        while(L!=null && L.next!=null)
        {
          ListNode k=new ListNode(t.val);
            k.next=L.next;
            L.next=k;
            t=t.next;
            L=L.next.next;
        }
        if(L!=null)
        {
            ListNode k=new ListNode(t.val);
            k.next=L.next;
            L.next=k;
            L=L.next;
            t=t.next;
            L.next=t;
        }
            }
        }
        
        
    }
}
