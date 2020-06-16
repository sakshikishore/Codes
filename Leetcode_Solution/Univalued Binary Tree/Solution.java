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
    boolean result=true;
    TreeSet<Integer> t=new TreeSet<Integer>();
    public boolean isUnivalTree(TreeNode root) {
        
        if(root!=null)
        {
            isUnivalTree(root.left);
            t.add(root.val);
            isUnivalTree(root.right);
        }
        
        if(t.size()>1)
        {
            result=false;
        }
        
        return result;
        
    }
}
