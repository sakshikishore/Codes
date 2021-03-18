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
    int sum=0;
    int p=0;
    public void InOrder1(TreeNode root)
    {
        if(root!=null)
        {
            InOrder1(root.left);
            sum+=root.val;
            InOrder1(root.right);
        }
    }
    public void InOrder2(TreeNode root)
    {
        if(root!=null)
        {
            InOrder2(root.left);
            p=root.val;
            root.val=sum;
            sum=sum-p;
            InOrder2(root.right);
        }
    }
    public TreeNode bstToGst(TreeNode root) {
        InOrder1(root);
        InOrder2(root);
        return root;        
    }
}
