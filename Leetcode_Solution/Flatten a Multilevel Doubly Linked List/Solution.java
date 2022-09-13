/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null)
        {
            return null;
        }
        Stack<Node> stck=new Stack<Node>();
        ArrayList<Integer> l=new ArrayList<Integer>();
        Node ptr=head;
        while(ptr!=null || stck.size()>0)
        {
            if(ptr.child!=null)
            {
                if(ptr.val!=-1)
                {
                  l.add(ptr.val);
                }
                stck.push(ptr);
                ptr=ptr.child;
            }
            else
            {
                if(ptr.val!=-1)
                {
                  l.add(ptr.val);
                }
                ptr=ptr.next;
                if(ptr==null && stck.size()>0)
                {
                    ptr=stck.pop();
                    ptr.child=null;
                    ptr.val=-1;
                }
            }
        }
        head=null;
        for(int i=0;i<l.size();i++)
        {
            Node obj=new Node();
            obj.val=l.get(i);
            obj.next=null;
            obj.prev=null;
            obj.child=null;
            if(head==null)
            {
                head=obj;
            }
            else
            {
                Node p=head;
                while(p.next!=null)
                {
                    p=p.next;
                }
                p.next=obj;
                p.next.prev=p;
            }
        }
        return head;
    }
}
