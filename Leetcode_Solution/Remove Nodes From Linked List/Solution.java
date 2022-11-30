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
    public ListNode removeNodes(ListNode head) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        HashSet<Integer> h=new HashSet<Integer>();
        ListNode ptr=head;
        while(ptr!=null)
        {
            l.add(ptr.val);
            ptr=ptr.next;
        }
        int max=0;
        for(int i=l.size()-1;i>=0;i--)
        {
            if(l.get(i)>=max)
            {
                max=l.get(i);
            }
            else
            {
                h.add(i);
            }
            
        }
        
        int j=0;
        ptr=head;
        ListNode q=head;
        while(ptr!=null)
        {
           if(h.contains(j))
           {
               if(ptr==head)
               {
                   head=ptr.next;
                   q=head;
                   ptr.next=null;
                   ptr=head;
               }
               else
               {
                 ptr=ptr.next;
                 q.next=ptr;
               }
           }
           else
           {
               q=ptr;
               ptr=ptr.next;
               
           }
           j++;
        }
        
        return head;
        
    }
}
