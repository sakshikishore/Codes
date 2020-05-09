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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev1=null;
        while(l1!=null)
        {
           ListNode next=l1.next;
            l1.next=prev1;
            prev1=l1;
            l1=next;
        }
        ListNode prev2=null;
        while(l2!=null)
        {
            ListNode next=l2.next;
            l2.next=prev2;
            prev2=l2;
            l2=next;
        }
        ListNode t=null;
        int carry=0;
        while(prev1!=null && prev2!=null)
        {
            int sum=prev1.val+prev2.val+carry;
            int p=sum%10;
            carry=sum/10;
            ListNode k=new ListNode(p);
            if(t==null)
            {
                t=k;
            }
            else
            {
                ListNode r=t;
                while(r.next!=null)
                {
                    r=r.next;
                }
                r.next=k;
                
            }
            prev1=prev1.next;
            prev2=prev2.next;
            
        }
        if(prev1!=null)
        {
            while(prev1!=null)
            {
            int sum=prev1.val+carry;
            int p=sum%10;
            carry=sum/10;
            ListNode k=new ListNode(p);
            if(t==null)
            {
                t=k;
            }
            else
            {
                ListNode r=t;
                while(r.next!=null)
                {
                    r=r.next;
                }
                r.next=k;
                
            }
            prev1=prev1.next;
            }
            if(carry==1)
            {
                 ListNode k=new ListNode(carry);
            if(t==null)
            {
                t=k;
            }
            else
            {
                ListNode r=t;
                while(r.next!=null)
                {
                    r=r.next;
                }
                r.next=k;
                
            } 
                carry=0;
            }
        }
          if(prev2!=null)
        {
            while(prev2!=null)
            {
            int sum=prev2.val+carry;
            int p=sum%10;
            carry=sum/10;
            ListNode k=new ListNode(p);
            if(t==null)
            {
                t=k;
            }
            else
            {
                ListNode r=t;
                while(r.next!=null)
                {
                    r=r.next;
                }
                r.next=k;
                
            }
            prev2=prev2.next;
            }
            if(carry==1)
            {
                 ListNode k=new ListNode(carry);
            if(t==null)
            {
                t=k;
            }
            else
            {
                ListNode r=t;
                while(r.next!=null)
                {
                    r=r.next;
                }
                r.next=k;
                
            } 
                carry=0;
            }
        }
         if(carry==1)
            {
                 ListNode k=new ListNode(carry);
            if(t==null)
            {
                t=k;
            }
            else
            {
                ListNode r=t;
                while(r.next!=null)
                {
                    r=r.next;
                }
                r.next=k;
                
            } 
         }
        ListNode prev=null;
        while(t!=null)
        {
            ListNode next=t.next;
            t.next=prev;
            prev=t;
            t=next;
        }
        return prev;
    }
}
