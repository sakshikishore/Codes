class Solution {
    public TreeNode getSolution(TreeNode root)
    {
        if(root!=null)
        {
           root.left=getSolution(root.left);
           root.right= getSolution(root.right);
           if((root.left!=null) || (root.right!=null))
           {
               return root;
           }
           if(root.val==0)
           {
                return null;
           }
        }
        return root;
    }
    public TreeNode pruneTree(TreeNode root) {
        return getSolution(root);
    }
}
