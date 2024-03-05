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
    public int getDecimalValue(ListNode head) {
        ListNode prev=null, curr=head;
        while(curr!=null)
        {
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }

        int res=0,i=0;
        ListNode ptr=prev;
        while(ptr!=null)
        {
            int x=ptr.val;
            res+=(int)Math.pow(2,i)*x;
            ptr=ptr.next;
            i++;
        }

        return res;
    }
}
