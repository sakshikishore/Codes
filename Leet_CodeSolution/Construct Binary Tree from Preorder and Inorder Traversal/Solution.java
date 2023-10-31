class Solution {
    public TreeNode Solve(int[] pre, int preStart,int preEnd, int[] in, int inStart, int inEnd)
    {
        if(preStart>preEnd || inStart>inEnd)
        {
            return null;
        }
            TreeNode root=new TreeNode(pre[preStart]);
            int x=inStart;
            while(in[x]!=pre[preStart])
            {
                x++;
            }
            root.left=Solve(pre,preStart+1,preStart+x-inStart,in,inStart,x-1);
            root.right=Solve(pre,preStart+x-inStart+1, preEnd, in, x+1, inEnd);

            return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return Solve(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
}
