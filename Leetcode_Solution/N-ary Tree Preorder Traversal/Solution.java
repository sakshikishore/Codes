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
    public List<Integer> preorder(Node root) {
     ArrayList<Integer> res=new ArrayList<Integer>();
     if(root!=null)
     {
         Stack<Node> stck=new Stack<Node>();
         stck.push(root);
         while(!stck.empty())
         {
             Node temp=stck.pop();
             res.add(temp.val);
             for(int i=temp.children.size()-1;i>=0;i--)
             {
                 stck.push(temp.children.get(i));
             }
         }
     }
        
        return res;
        
    }
}
