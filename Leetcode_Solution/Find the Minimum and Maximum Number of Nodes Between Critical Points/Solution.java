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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int arr[]=new int[2];
        arr[0]=-1;
        arr[1]=-1;
        ArrayList<Integer> l=new ArrayList<Integer>();
        ListNode ptr=head;
        int count=0;
        int prev=-1;
        while(ptr!=null)
        {
           count++;
          if(prev==-1)
          {
              prev=ptr.val;
              ptr=ptr.next;
          }
          else
          {
              if(ptr.next!=null)
              {
                 if(ptr.val>prev && ptr.val>ptr.next.val)
                 {
                     l.add(count);
                 }
                 else if(ptr.val<prev && ptr.val<ptr.next.val)
                 {
                     l.add(count);
                 }
                 prev=ptr.val;
                 ptr=ptr.next;
              }
              else
              {
                  break;
              }
          }
        
          
        }
        
        if(l.size()>1)
        {
            int max=Integer.MAX_VALUE;
            arr[1]=l.get(l.size()-1)-l.get(0);
            for(int i=1;i<l.size();i++)
            {
                if(l.get(i)-l.get(i-1)<max)
                {
                    max=l.get(i)-l.get(i-1);
                }
            }
            
            arr[0]=max;
        }
        
        return arr;
        
    }
}
