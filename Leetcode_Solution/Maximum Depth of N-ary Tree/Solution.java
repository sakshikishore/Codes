/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
     int maxdepth=0;
     if(root!=null)
     {
         Queue<Node> q=new LinkedList<Node>();
         q.add(root);
         q.add(null);
         while(q.size()!=0)
         {
             Node temp=q.poll();
             if(temp!=null)
             {
                 for(int i=0;i<temp.children.size();i++)
                 {
                     q.add(temp.children.get(i));
                 }
             }
             else
             {
                 maxdepth++;
                 if(q.size()!=0)
                 {
                     q.add(null);
                 }
             }
         }
     }
        
        return maxdepth;
        
    }
}
