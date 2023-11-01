class Solution {
    public TreeNode solve(int in[], int instart,int inend, int post[], int poststart,int postend)
    {
        if(instart>inend || poststart>postend)
        {
            return null;
        }
        TreeNode root=new TreeNode(post[postend],null,null);
        int x=instart;
        while(in[x]!=post[postend])
        {
            x++;
        }
        root.left=solve(in,instart,x-1,post,poststart,poststart+x-instart-1);
        root.right=solve(in,x+1,inend,post,poststart+x-instart,postend-1);

        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return solve(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
}
