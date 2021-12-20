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
    public ListNode deleteMiddle(ListNode head) {
    ListNode ptr=head;
    int count=0;
    while(ptr!=null)
    {
        count++;
        ptr=ptr.next;
    }
        if(count>1)
        {
    int middle=count/2;
    ListNode p=head,q=head;
    int i=0;
    while(i<middle)
    {
        p=q;
        q=q.next;
        i++;
    }
        p.next=q.next;
        q.next=null;
        }
        else
        {
            head=null;
        }
        
        return head;
        
    }
}
