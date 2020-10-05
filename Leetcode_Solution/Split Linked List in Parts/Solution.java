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
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode ptr=root;
        int len=0;
        while(ptr!=null)
        {
            len++;
            ptr=ptr.next;
        }
        
        ListNode l[]=new ListNode[k];
        
        int p=len/k;
        int q=len%k;
        ListNode curr=root;
        int i=0;
        
        while(curr!=null)
        {                  
            int total=p;
            if(q>0)
            {
              total+=1;
                q--;
            }
            ListNode r=root;
            for(int j=0;j<total;j++)
            {
                r=curr;
                curr=curr.next;
            }
            r.next=null;
            l[i]=root;
            root=curr;
           
            i++;
        }
        
        return l;
        
    }
}
