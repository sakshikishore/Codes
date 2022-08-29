class Solution {
    public int result=Integer.MIN_VALUE;
    int ans=Integer.MIN_VALUE;
    int getMaximumPathSum(TreeNode root,int result)
    {
        if(root==null)
        {
            return 0;
        }
        int l=getMaximumPathSum(root.left,result);
        int r=getMaximumPathSum(root.right,result);
        int path1=Math.max((Math.max(l,r)+root.val),root.val);
        int maxSum=Math.max(path1,(l+r+root.val));
        result=Math.max(result,maxSum);
        if(ans<result)
        {
            ans=result;
        }
        return path1;
    }
    public int maxPathSum(TreeNode root) {
      getMaximumPathSum(root,result);
      return ans;
    }
}
