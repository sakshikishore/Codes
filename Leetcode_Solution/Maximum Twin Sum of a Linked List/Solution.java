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
    public int pairSum(ListNode head) {
        int max=0;
        ArrayList<Integer> l=new ArrayList<Integer>();
        ListNode ptr=head;
        while(ptr!=null)
        {
            l.add(ptr.val);
            ptr=ptr.next;
        }
        
        for(int i=0;i<l.size()/2;i++)
        {
            int sum=l.get(i)+l.get(l.size()-i-1);
            if(sum>max)
            {
                max=sum;
            }

        }
        
        return max;
        
    }
}
