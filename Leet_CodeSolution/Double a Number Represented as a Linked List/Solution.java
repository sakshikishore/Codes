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
    public ListNode doubleIt(ListNode head) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        ListNode ptr=head;
        while(ptr!=null)
        {
            l.add(ptr.val);
            ptr=ptr.next;
        }
        
        Stack<Integer> stck=new Stack<Integer>();
        int carry=0;
        for(int i=l.size()-1;i>=0;i--)
        {
            int x=(2*l.get(i))+carry;
            if(x>9)
            {
                carry=1;
            }
            else
            {
                carry=0;
            }
            stck.push(x%10);
        }
        if(carry==1)
        {
            stck.push(1);
        }
        head=null;
        while(stck.size()!=0)
        {
            int val=stck.pop();
            if(head==null)
            {
                head=new ListNode(val,null);
            }
            else
            {
                ptr=head;
                while(ptr.next!=null)
                {
                    ptr=ptr.next;
                }
                ptr.next=new ListNode(val,null);
            }
        }
        
        return head;
        
    }
}
