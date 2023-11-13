class Solution {
    public int maximumStrongPairXor(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<nums.length;j++)
            {
                int p=Math.abs(nums[i]-nums[j]);
            
            int min=Math.min(nums[i],nums[j]);
            if(p<=min)
            {
                if((nums[i]^nums[j])>result)
                {
                    result=nums[i]^nums[j];
                }
            }
            }
        }
        
        return result;
    }
}
