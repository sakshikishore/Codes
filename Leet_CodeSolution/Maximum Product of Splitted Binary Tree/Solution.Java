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
    long sum=0;
    long max=0;
    HashMap<TreeNode,Long> h=new HashMap<TreeNode,Long>();
    public void InOrder(TreeNode root)
    {
        if(root!=null)
        {
           InOrder(root.left);
           sum+=root.val;
           InOrder(root.right);
        }
    }
    public void postOrder(TreeNode root)
    {
         if(root!=null)
        {
          postOrder(root.left);
          postOrder(root.right);
          long value=root.val*1l;
          if(root.left!=null)
          {
            value+=h.get(root.left);
          }
          if(root.right!=null)
          {
            value+=h.get(root.right);
          }
          h.put(root,value);
          long p=value*(sum-value);
          max=Math.max(max,p);
          
        }
    }
    public int maxProduct(TreeNode root) {
        InOrder(root);
        postOrder(root);

        return (int)(max%(1000000007));

    }
}
