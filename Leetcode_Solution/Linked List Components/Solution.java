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
    public int numComponents(ListNode head, int[] G) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        int result=0;
        for(int i=0;i<G.length;i++)
        {
            l.add(G[i]);
        }
        ListNode curr=head;
        int count=0;
        while(curr!=null)
        {
            if(l.contains(curr.val))
            {
                count++;
            }
            else
            {
                if(count>0)
                {
                    result++;
                    count=0;
                }
            }
            
            curr=curr.next;
        }
        
        if(count>0)
        {
            result++;
        }
        
        
        return result;
        
    }
}
