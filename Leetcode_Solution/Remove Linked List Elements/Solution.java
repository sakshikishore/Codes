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
    public ListNode removeElements(ListNode head, int val) {
    ListNode ptr=head;
    ListNode p=head;
        while(ptr!=null)
        {
            if(head.val==val)
            {
              head=head.next;
              ptr.next=null;
              ptr=head;
            }
            else
            {
                if(ptr.val==val)
                {
                    p.next=ptr.next;
                    ptr.next=null;
                    ptr=p.next;
                }
                else
                {
                p=ptr;
                ptr=ptr.next;
                }

            }
        }
        
        return head;
        
    }
}
