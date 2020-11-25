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
    public boolean hasPathSum(TreeNode root, int sum) {
        boolean result=false;
        if(root!=null)
        {
            HashMap<TreeNode,Integer> h=new HashMap<TreeNode,Integer>();
            Queue<TreeNode> q=new LinkedList<TreeNode>();
            q.add(root);
            h.put(root,root.val);
            while(q.size()!=0)
            {
                TreeNode temp=q.poll();
                if(temp.left==null && temp.right==null && h.get(temp)==sum)
                {
                    result=true;
                    break;
                }
                if(temp.left!=null)
                {
                    h.put(temp.left,h.get(temp)+temp.left.val);
                    q.add(temp.left);
                }
                if(temp.right!=null)
                {
                    h.put(temp.right,h.get(temp)+temp.right.val);
                    q.add(temp.right);
                }
            }
        }
        
        return result;
        
    }
}
