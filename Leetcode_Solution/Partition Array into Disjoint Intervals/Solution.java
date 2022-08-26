class Solution {
    public int partitionDisjoint(int[] nums) {
        int max=nums[0];
        int rightmax=nums[0];
        int leftmax=nums[0];
        int ans=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]<leftmax)
            {
                leftmax=rightmax;
                ans=i+1;
            }
            else
            {
                if(nums[i]>rightmax)
                {
                    rightmax=nums[i];
                }
            }
        }
        
        return ans;

     }
}
