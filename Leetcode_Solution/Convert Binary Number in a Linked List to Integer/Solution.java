/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        int sum=0;
        int k=0;
        String str="";
        ListNode p=head;
        while(p!=null)
        {
            str=str+Integer.toString(p.val);
            p=p.next;
        }
        for(int i=str.length()-1;i>=0;i--)
        {
            sum=sum+((int)Math.pow(2,k))*Integer.parseInt(str.substring(i,i+1));
            k++;
        }
    return sum;
        
    }
}
