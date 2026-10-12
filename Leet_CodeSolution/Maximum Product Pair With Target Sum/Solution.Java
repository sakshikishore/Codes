class Solution {
    public int[] maxProductPair(int[] nums, int target) {
        int result[]={-1,-1};
        int max=-10001;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]+nums[j]==target && nums[i]!=nums[j])
                {
                    if(nums[i]*nums[j]>max)
                    {
                        max=nums[i]*nums[j];
                        if(nums[i]>nums[j])
                        {
                            result[0]=i;
                            result[1]=j;
                        }
                        else
                        {
                            result[0]=j;
                            result[1]=i;
                        }
                    }
                }
            }
        }

        return result;
    }
}
