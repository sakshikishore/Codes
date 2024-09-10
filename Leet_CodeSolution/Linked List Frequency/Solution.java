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
    public ListNode frequenciesOfElements(ListNode head) {
      HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
      while(head!=null)
      {
        if(!map.containsKey(head.val))
        {
            map.put(head.val,1);
        }
        else
        {
            map.put(head.val,map.get(head.val)+1);
        }
        head=head.next;
      }

      for(Map.Entry<Integer,Integer> entry:map.entrySet())
      {
        int val=entry.getValue();
        if(head==null)
        {
            head=new ListNode(val,null);
        }
        else
        {
            ListNode ptr=new ListNode(val,null);
            ptr.next=head;
            head=ptr;            
        }
      }

      return head;
    }
}
