/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(root!=null)
        {
            Queue<TreeNode> q=new LinkedList<TreeNode>();
            q.add(root);
            q.add(null);
            ArrayList<Integer> l=new ArrayList<Integer>();
            while(q.size()!=0)
            {
               TreeNode temp=q.poll();
                if(temp!=null)
                {
                    l.add(temp.val);
                    if(temp.left!=null)
                    {
                        q.add(temp.left);
                    }
                    if(temp.right!=null)
                    {
                        q.add(temp.right);
                    }
                }
                else
                {
                    
                    list.add(l.get(l.size()-1));
                    
                    if(q.size()!=0)
                    {
                        q.add(null);
                        l=new ArrayList<Integer>();
                    }
                }
            }
        }
        
        return list;
    }
}
