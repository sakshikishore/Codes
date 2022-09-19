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
    public ListNode reverseEvenLengthGroups(ListNode head) {
        int i=1;
        ListNode root=null;
        ListNode ptr=head;
        while(ptr!=null)
        {
            if(i==1)
            {
               root=new ListNode(ptr.val,null);
               ptr=ptr.next;
               i++;
            }
            int x=0;
            ListNode r=ptr;
            for(int j=1;j<=i;j++)
            {
               if(r!=null)
               {
                   x++;
                   r=r.next;
               }
                
            }
            if(x%2!=0)
            {
                ListNode k=root;
                while(k.next!=null)
                {
                    k=k.next;
                }
                for(int j=1;j<=i;j++)
                {
                    if(ptr!=null)
                    {
                        k.next=new ListNode(ptr.val,null);
                        ptr=ptr.next;
                        k=k.next;
                    }
                }
                
                 i++;
            }
            else
            {
                 ListNode p=null;
                 for(int j=1;j<=i;j++)
                 {
                     if(ptr!=null)
                     {
                         if(p==null)
                         {
                             p=new ListNode(ptr.val,null);
                         }
                         else
                         {
                             ListNode t=new ListNode(ptr.val,null);
                             t.next=p;
                             p=t;
                         }  
                         
                         ptr=ptr.next;
                     }
                 }
                ListNode k=root;
                while(k.next!=null)
                {
                    k=k.next;
                }
                k.next=p;
                i++;
            }
        }
        
        return root;
        
    }
}
