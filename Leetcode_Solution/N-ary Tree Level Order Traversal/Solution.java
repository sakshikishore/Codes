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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root!=null)
        {  
        Queue<Node> q=new LinkedList<Node>();
        q.add(root);
        q.add(null);
        
        ArrayList<Integer> l=new ArrayList<Integer>();
        while(q.size()!=0)
        {
            Node temp=q.poll();
            if(temp!=null)
            {
                l.add(temp.val);
                for(int i=0;i<temp.children.size();i++)
                {
                    q.add(temp.children.get(i));
                }
            }
            else
            {
                list.add(l);
                if(q.size()!=0)
                {
                    l=new ArrayList<Integer>();
                    q.add(null);
                }
            }
        }
        }
        
        return list;
        
    }
}
