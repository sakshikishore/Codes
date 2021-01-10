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
    public ListNode swapNodes(ListNode head, int k) {
     int len=0,a=0;
     ListNode ptr=head;
        while(ptr!=null)
        {
            len++;
            if(len==k)
            {
                a=ptr.val;
            }
            ptr=ptr.next;
        }
        
        int p=len-k+1;
        int b=0,i=1;
        ListNode q=head;
        while(i<p)
        {
            q=q.next;
            i++;
        }
        b=q.val;
        q.val=a;
        ListNode res=head;
        int c=1;
        while(c<k)
        {
            res=res.next;
            c++;
        }
        res.val=b;
        
        return head;
        
    }
}
