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
    public int[] nextLargerNodes(ListNode head) {
        ListNode prev=null;
        ListNode curr=head;
        int count=0;
        while(curr!=null)
        {
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
            count++;
        }
        
        head=prev;
        int arr[]=new int[count];
        ListNode ptr=head;
        int max=0;
        int i=count-1;
        ArrayList<Integer> l=new ArrayList<Integer>();
        while(ptr!=null)
        {        
               while(l.size()>0)
               {
                   if(l.get(l.size()-1)>ptr.val)
                   {
                       arr[i]=l.get(l.size()-1);
                       
                       break;
                   }
                   else
                   {
                       l.remove(l.size()-1);
                   }
               }
            
            l.add(ptr.val);
            
            i--;
            
            ptr=ptr.next;
        }
        
        return arr;
        
        
    }
}
