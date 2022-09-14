/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node root=null;
        Node ptr=head;
        HashMap<Node,Integer> h=new HashMap<Node,Integer>();
        int i=0;
        while(ptr!=null)
        {
            h.put(ptr,i);
            i++;
            if(root==null)
            {
                root=new Node(ptr.val);
            }
            else
            {
                Node p=root;
                while(p.next!=null)
                {
                    p=p.next;
                }
                p.next=new Node(ptr.val);
            }
            ptr=ptr.next;
        }
        ptr=head;
        Node p=root;
        while(ptr!=null)
        {
            Node a=ptr.random;
            if(a==null)
            {
                p=p.next;
            }
            else
            {
                int index=h.get(a);
                Node q=root;
                int k=0;
                while(q!=null)
                {
                   if(k==index)
                   {
                     p.random=q;
                     p=p.next;
                     break;
                   }
                    else
                    {
                        q=q.next;
                        k++;
                    }
                }
            }
            ptr=ptr.next;
        }
        return root;
    }
}
