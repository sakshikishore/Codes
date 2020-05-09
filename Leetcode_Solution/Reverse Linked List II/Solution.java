/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode p=head;
        ListNode z=null;
        int i=1;
        while(i<=n)
        {
            z=p;
            p=p.next;
            i++;
        }
        z.next=null;
        int j=1;
        ListNode q=head;
        ListNode r=head;
        int count=0;
        while(j<m)
        {
            count++;
            r=q;
            q=q.next;
            j++;
        }
    
        while(q!=null)
        {
            ListNode next=q.next;
            q.next=p;
            p=q;
            q=next;
        }
        if(count>0)
        {
       r.next=p;
        }
        else
        {
            head=p;
        }
        return head;
        
    }
}
