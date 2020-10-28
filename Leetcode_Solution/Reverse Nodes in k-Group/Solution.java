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
    public ListNode reverseKGroup(ListNode head, int k) {
        int count=0;
        ListNode ptr=head;
        ArrayList<Integer> list= new ArrayList<Integer>();
        while(ptr!=null)
        {
            count++;
            list.add(ptr.val);
            ptr=ptr.next;
        }
        int p=count/k;
        int j=k-1;
        int i=0,l=0;
        head=null;
    
        while(i<count)
        {
            ListNode node=new ListNode(list.get(j),null);
            if(head==null)
            {
                head=node;        
            }
            else
            {
                ListNode g=head;
                while(g.next!=null)
                {
                    g=g.next;
                }
                g.next=node;
            }
            i++;
            if(i%k==0)
            {
                l++;
                if(l<p)
                {
                 j=((l+1)*k);
                }
                else
                {
                    j=(l*k)-1;
                }
            
            }
            if(l<p)
            {
             j--;
            }
            else
            {
                j++;
            }
        }
        
        return head;
        
    }
}
