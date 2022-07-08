class Solution {
    public TreeNode insertBST(int nums[],int start,int end)
    {
        if(start>end)
        {
            return null;
        }
        int mid=(start+end)/2;
        TreeNode root=new TreeNode(nums[mid],null,null);
        root.left=insertBST(nums,start,mid-1);
        root.right=insertBST(nums,mid+1,end);
        
        return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
     return insertBST(nums,0,nums.length-1);
    }
}
