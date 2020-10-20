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
    public ListNode rotateRight(ListNode head, int k) {
        int len=0;
        ListNode curr=head;
        while(curr!=null)
        {
            len++;
            curr=curr.next;
        }
        if(len>1 && k>0 && k%len!=0)
        {
        k=k%len;
        int p=len-k;
        ListNode ptr=head;
        int i=0;
        while(i<p-1)
        {
            ptr=ptr.next;
            i++;
        }
        ListNode head1=ptr.next;
        ptr.next=null;
        
        ListNode q=head1;
        while(q.next!=null)
        {
            q=q.next;
        }
        
        q.next=head;
        
        head=head1;
            
        }            
        return head;
        
        
    }
}
