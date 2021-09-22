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
    public int height(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        
            int hleft=height(root.left);
            int hright=height(root.right);
            if(hleft>hright)
            {
                return hleft+1;
            }
        else
        {
            return hright+1;
        }
        
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null)
        {
            return true;
        }
        int hl=height(root.left);
        int hr=height(root.right);
        return (Math.abs(hl-hr)<=1) && isBalanced(root.left) && isBalanced(root.right);
    }
}
