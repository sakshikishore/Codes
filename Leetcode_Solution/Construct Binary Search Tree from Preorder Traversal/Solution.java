class Solution {
    public TreeNode InsertBST(TreeNode data,TreeNode root)
    {
        if(root==null)
        {
            return data;
        }
        if(root.val>data.val)
        {
            root.left=InsertBST(data,root.left);
        }
        else
        {
            root.right=InsertBST(data,root.right);
        }
        
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=null;
        for(int i=0;i<preorder.length;i++)
        {
            TreeNode t=new TreeNode(preorder[i],null,null);
           root= InsertBST(t,root);
        }
        
        return root;
    }
}
