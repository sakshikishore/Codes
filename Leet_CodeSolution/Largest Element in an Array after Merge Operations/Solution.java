class Solution {
    public long maxArrayValue(int[] nums) {
        long max=0;
        long sum=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i]<=sum)
            {
                sum=sum+nums[i];
            }
            else
            {
                if(sum>max)
                {
                    max=sum;
                    sum=nums[i];
                }
            }
        }
        if(sum>max)
                {
                    max=sum;
                }
        
        
        return max;
        
    }
}
