class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int p=1;
        int max=0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>nums[i-1])
            {
                p++;
            }
            else
            {
                if(p>max)
                {
                    max=p;
                }
                p=1;
            }
        }
        
        if(nums.length>0 && p>max)
        {
            max=p;
        }
        
        return max;
    }
}
