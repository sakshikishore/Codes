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
    public ListNode removeZeroSumSublists(ListNode head) {
        Stack<Integer> stck=new Stack<Integer>();
        ListNode ptr=head;
        int count=0;
        while(ptr!=null)
        {
            if(stck.size()==0)
            {
                if(ptr.val!=0)
                {
                stck.push(ptr.val);
                }
               
            }
            else
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                int res=0;
               count=0;
                while(stck.size()!=0)
                {
                    if(stck.peek()+res+ptr.val==0)
                    {
                        stck.pop();
                        count++;
                        break;
                    }
                    else
                    {
                       int p=stck.pop();
                        l.add(p);
                        res+=p;
                    }
                }
                if(count==0)
                {
                    int k=l.size()-1;
                    while(k>=0)
                    {
                        stck.push(l.get(k));
                        k--;
                    }
                    if(ptr.val!=0)
                    {
                    stck.push(ptr.val);
                    }
                }
            }
            ptr=ptr.next;
        }
        ListNode root=null;
        while(stck.size()!=0)
        {
            if(root==null)
            {
               root=new ListNode(stck.pop(),null);
                         
            }
            else
            {

                ListNode m=new ListNode(stck.pop(),null);
                m.next=root;
                root=m;
            }
        }
        return root;
    }
}
