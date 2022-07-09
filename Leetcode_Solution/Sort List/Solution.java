class Solution {
    public ListNode sortList(ListNode head) {
       PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
        ListNode ptr=head;
        while(ptr!=null)
        {
            pq.add(ptr.val);
            ptr=ptr.next;
        }
        
        ListNode root=null;
        while(pq.size()!=0)
        {
            ListNode r=new ListNode(pq.poll(),null);
            if(root==null)
            {
                root=r;
            }
            else
            {
                r.next=root;
                root=r;
            }
        }
        
        return root;
        
    }
}
