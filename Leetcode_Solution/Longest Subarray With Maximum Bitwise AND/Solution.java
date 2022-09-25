class Solution {
    public int longestSubarray(int[] nums) {
        int max=0;
        int maxLength=1;
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>max)
            {
                max=nums[i];
            }
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==max)
            {
                count++;
            }
            else
            {
                if(count>maxLength)
                {
                    maxLength=count;
                }
                count=0;
            }
        }
                if(count>maxLength)
                {
                    maxLength=count;
                }
        
        return maxLength;
    }
}
