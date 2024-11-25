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
     HashMap<TreeNode,Integer> h=new HashMap<TreeNode,Integer>();
     int max=0;
    public void postOrder(TreeNode root)
    {
        if(root!=null)
        {
            postOrder(root.left);
            postOrder(root.right);
            int m1=0,m2=0;
            if(root.left!=null)
            {
                if(root.left.val==root.val)
                {
                   m1=h.get(root.left);
                }
            }
            if(root.right!=null)
            {
                if(root.right.val==root.val)
                {
                    m2=h.get(root.right);
                }
            }
            if(m1+m2+1>max)
            {
                max=m1+m2+1;
            }
            int p=Math.max(m1,m2);
            h.put(root,p+1);
        }
    }
    public int longestUnivaluePath(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
       postOrder(root);
       return max-1;
    }
}
