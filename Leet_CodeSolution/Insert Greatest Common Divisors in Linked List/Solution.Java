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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode p=head;
        ListNode ptr=head;
        ptr=ptr.next;
        while(ptr!=null)
        {
            int a=p.val;
            int b=ptr.val;
            while(b!=0)
            {
                int r=a%b;
                a=b;
                b=r;
            }
            p.next=new ListNode(a,ptr);
            p=p.next.next;
            ptr=ptr.next;
        }

        return head;
    }
}
