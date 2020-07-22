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
    public ListNode swapPairs(ListNode head) {
        ListNode t=head;
        int count=0;
        while(t!=null)
        {
            count++;
            t=t.next;
        }
        if(count>=2)
        {
            ListNode ptr=head;
            ListNode p=ptr.next;
            ptr.next=p.next;
            p.next=ptr;
            head=p;
            int i=2;
            while(i<count)
            {
                if(count%2==0 || (count%2!=0 && i!=count-1 ))
                {
                    ListNode k=ptr.next;
                    ptr.next=ptr.next.next;
                    k.next=null;
                    ptr=ptr.next;
                    k.next=ptr.next;
                    ptr.next=k;
                    ptr=k;
                    i=i+2;
                }
                else
                {
                    break;
                }
            }
        }
        
        
        
        return head;
    }
}
