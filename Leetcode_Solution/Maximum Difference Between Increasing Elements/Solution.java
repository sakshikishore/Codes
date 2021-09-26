class Solution {
    public int maximumDifference(int[] nums) {
        int min=nums[0];
        int max=-1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>min)
            {
                if(nums[i]-min>max)
                {
                    max=nums[i]-min;
                }
                
            }
            else
            {
                if(nums[i]<min)
                {
                    min=nums[i];
                }
            }
        }
        
        return max;
        
    }
}
