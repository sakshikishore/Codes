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
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<lists.length;i++)
        {
            while(lists[i]!=null)
            {
                l.add(lists[i].val);
                lists[i]=lists[i].next;
            }
        }        
        Collections.sort(l);
        ListNode head=null;
        int i=0;
        while(i<l.size())
        {
            ListNode k=new ListNode(l.get(i),null);
            if(head==null)
            {
                head=k;
            }
            else
            {
                ListNode ptr=head;
                while(ptr.next!=null)
                {
                    ptr=ptr.next;
                }
                
                ptr.next=k;
            }
            i++;
        }
        return head;
        
    }
}
