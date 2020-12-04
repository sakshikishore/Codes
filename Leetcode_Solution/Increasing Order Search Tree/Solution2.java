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
    ArrayList<Integer> l=new ArrayList<Integer>();
    public void InOrder(TreeNode root)
    {
        if(root!=null)
        {
            InOrder(root.left);
            l.add(root.val);
            InOrder(root.right);
        }
    }
    public TreeNode increasingBST(TreeNode root) {
        InOrder(root);
        root=null;
        TreeNode r=null;
        for(int i=0;i<l.size();i++)
        {
            if(root==null)
            {
                root=new TreeNode(l.get(i),null,null);
                r=root;
            }
            else
            {
                
                r.right=new TreeNode(l.get(i),null,null);
                r=r.right;
            }
        }
        
        return root;
        
    }
}
