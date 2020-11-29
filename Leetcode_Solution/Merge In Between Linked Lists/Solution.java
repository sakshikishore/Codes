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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode ptr=list1;
        ListNode q=null;
        int count=0;
        while(ptr!=null)
        {
            if(ptr.val==a)
            {
                count++;
                if(q==null)
                {
                    q=list2;
                    list1=q;
                }
                else
                {
              q.next=list2;
                }
            }
            if(ptr.val==b)
            {
              ListNode k=list2;
                while(k.next!=null)
                {
                    k=k.next;
                }
                k.next=ptr.next;
                ptr.next=null;
                break;
            }
            if(count==0)
                {
                q=ptr;
                }
               
            
             ptr=ptr.next;
        }
        
        return list1;
        
    }
}
