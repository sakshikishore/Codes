class Solution {
    public TreeNode Construct(int start,int end,int nums[])
    {
        if(start>end)
        {
            return null;
        }
        int max=-1;
        int index=0;
        for(int i=start;i<=end;i++)
        {
            if(nums[i]>max)
            {
                max=nums[i];
                index=i;
            }
        }
        TreeNode root=new TreeNode(nums[index],null,null);
       root.left=Construct(start,index-1,nums);
       root.right=Construct(index+1,end,nums);
            
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
      return Construct(0,nums.length-1,nums);
    }
}
