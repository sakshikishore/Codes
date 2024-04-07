class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int max1=1,max2=1;
        for(int i=0;i<nums.length;i++)
        {
            int count=0;
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[j]>nums[j-1])
                {
                    count++;
                }
                else
                {
                    break;
                }
            }
            if(count+1>max1)
            {
                max1=count+1;
            }
        }
         for(int i=0;i<nums.length;i++)
        {
            int count=0;
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[j]<nums[j-1])
                {
                    count++;
                }
                else
                {
                    break;
                }
            }
            if(count+1>max2)
            {
                max2=count+1;
            }
        }
        
        return Math.max(max1,max2);
        
    }
}
