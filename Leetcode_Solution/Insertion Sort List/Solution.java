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
    public ListNode insertionSortList(ListNode head) {
        int len=0;
        ListNode curr=head;
        while(curr!=null)
        {
            len++;
            curr=curr.next;
        }
        
        int arr[]=new int[len];
        curr=head;
        int r=0;
        while(curr!=null)
        {
            arr[r]=curr.val;
            curr=curr.next;
            r++;
        }
        
        for(int i=1;i<arr.length;i++)
        {
            int k=i-1;
            int key=arr[i];
            while(k>=0 && arr[k]>key)
            {
                arr[k+1]=arr[k];
                k=k-1;
            }
            arr[k+1]=key;
        }
        head=null;
        for(int i=0;i<arr.length;i++)
        {
            ListNode p=new ListNode(arr[i],null);
            if(head==null)
            {
                head=p;
            }
            else
            {
                ListNode q=head;
                while(q.next!=null)
                {
                    q=q.next;
                }
                q.next=p;
            }
        }
        
        return head;
        
    }
}
