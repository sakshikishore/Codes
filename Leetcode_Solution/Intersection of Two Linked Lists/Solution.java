/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode,Integer> h=new HashMap<ListNode,Integer>();
        ListNode current=headA;
        while(current!=null)
        {
            h.put(current,1);
            current=current.next;
        }
        ListNode p=null;
        ListNode curr=headB;
        while(curr!=null)
        {
            if(h.containsKey(curr))
            {
                p=new ListNode(curr.val);
                break;
            }
            else
            {
                curr=curr.next;
            }
            
        }
        return p;
        
    }
}
