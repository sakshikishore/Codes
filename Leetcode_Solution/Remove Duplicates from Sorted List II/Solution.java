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
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        ListNode p=head;
        while(p!=null)
        {
            if(!h.containsKey(p.val))
            {
                h.put(p.val,1);
            }
            else
            {
                h.put(p.val,h.get(p.val)+1);
            }
            p=p.next;
                
        }
        ListNode curr=head;
        ListNode head1=null;
        while(curr!=null)
        {
            if(h.get(curr.val)==1)
            {
                ListNode t=new ListNode(curr.val,null);
                if(head1==null)
                {
                    head1=t;
                }
                else
                {
                    ListNode q=head1;
                    while(q.next!=null)
                    {
                        q=q.next;
                    }
                    q.next=t;
                }
            }
            curr=curr.next;
        }
        
        return head1;
        
    }
}
