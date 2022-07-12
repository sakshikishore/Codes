class Solution {
    int res=0;
    public int tilt(TreeNode root)
    {   if(root==null)
        {
            return 0;
        }
        int ls=tilt(root.left);
        int rs=tilt(root.right);
        res+=Math.abs(ls-rs);
        return ls+rs+root.val;
    }
    public int findTilt(TreeNode root) {
        tilt(root);
        return res;
    }
}
