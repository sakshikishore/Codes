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
    public ListNode mergeNodes(ListNode head) {
    ListNode ptr=null;
    int sum=0;
    ListNode q=null;
    while(head!=null)
    {
        if(head.val!=0)
        {
            sum=sum+head.val;
        }
        else
        {
            if(sum!=0)
            {
            if(ptr==null)
            {
                ptr=new ListNode(sum,null);
                q=ptr;
            }
            else
            {
               q.next=new ListNode(sum,null);
               q=q.next;
            }
            }
            sum=0;
        }
        
        head=head.next;
    }
        
        return ptr;
        
    }
}
