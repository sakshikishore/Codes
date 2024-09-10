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
    public String gameResult(ListNode head) {
        int evenScore=0,oddScore=0;
        while(head!=null)
        {
            int p=head.val;
            head=head.next;
            if(p>head.val)
            {
                evenScore++;
            }
            else
            {
                oddScore++;
            }
            head=head.next;
        }
        if(evenScore==oddScore)
        {
            return "Tie";
        }

        return evenScore>oddScore?"Even":"Odd";
    }
}
