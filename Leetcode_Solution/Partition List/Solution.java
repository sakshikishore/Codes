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
    public ListNode partition(ListNode head, int x) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        ListNode curr=head;
        while(curr!=null)
        {
            if(curr.val<x)
            {
                l.add(curr.val);
            }
            curr=curr.next;
        }
        
        ListNode ptr=head;
        while(ptr!=null)
        {
            if(ptr.val>=x)
            {
                l.add(ptr.val);
            }
            ptr=ptr.next;
        }
        
        head=null;
        int i=0;
        while(i<l.size())
        {
            ListNode p=new ListNode(l.get(i),null);
            if(head==null)
            {
              
                head=p;
            }
            else
            {
                ListNode q=head;
                while(q.next!=null)
                {
                    q=q.next;
                }
                q.next=p;
            }
            
            i++;
        }
        
        return head;
        
    }
}
