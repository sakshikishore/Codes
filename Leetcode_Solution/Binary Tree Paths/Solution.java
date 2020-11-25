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
    public List<String> binaryTreePaths(TreeNode root) {
    ArrayList<String> res=new ArrayList<String>();
        if(root!=null)
        {
            HashMap<TreeNode,String> h=new HashMap<TreeNode,String>();
            Queue<TreeNode> q=new LinkedList<TreeNode>();
            q.add(root);
            h.put(root,Integer.toString(root.val));
            while(q.size()!=0)
            {
                TreeNode temp=q.poll();
                if(temp.left==null && temp.right==null)
                {
                    res.add(h.get(temp));
                }
                if(temp.left!=null)
                {
                    h.put(temp.left,h.get(temp)+"->"+Integer.toString(temp.left.val));
                    q.add(temp.left);
                }
                if(temp.right!=null)
                {
                    h.put(temp.right,h.get(temp)+"->"+Integer.toString(temp.right.val));
                    q.add(temp.right);
                }
                
            }
        }
        
        return res;
        
    }
}
