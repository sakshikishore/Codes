class Solution {
    public int maxWidthRamp(int[] nums) {
        int max=0;
        for(int j=nums.length-1;j>=1;j--)
        {
            if(j<=max)
            {
               break; 
            }
            for(int i=0;i<j;i++)
            {
                if(nums[i]<=nums[j])
                {
                    if(j-i>max)
                    {
                        max=j-i;
                    }
                    break;
                }
            }
        }
        
        return max;
    }
}
