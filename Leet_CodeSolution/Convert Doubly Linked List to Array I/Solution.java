/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
};
*/

class Solution {
    public int[] toArray(Node head) {
       Node ptr=head;
        int len=0;
        while(ptr!=null)
        {
           ptr=ptr.next;
           len++; 
        }
        int res[]=new int[len];
        int i=0;
         while(head!=null)
        {
             res[i]=head.val;
           head=head.next;
           i++; 
        }
        return res;
    }
}
