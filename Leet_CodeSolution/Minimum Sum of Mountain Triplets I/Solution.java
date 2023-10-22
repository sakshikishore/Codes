class Solution {
    public int minimumSum(int[] nums) {
        int result=-1;
        int pref[]=new int[nums.length];
        int min=nums[0];
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<min)
            {
                min=nums[i];
            }
            pref[i]=min;
        }
        int suf[]=new int[nums.length];
       min=nums[nums.length-1];
        for(int i=nums.length-1;i>=0;i--)
        {
            if(nums[i]<min)
            {
                min=nums[i];
            }
            suf[i]=min;
        }
        
        for(int i=1;i<nums.length-1;i++)
        {
            if(pref[i-1]<nums[i] && nums[i]>suf[i+1])
            {
                if(result==-1)
                {
                    result=pref[i-1]+nums[i]+suf[i+1];
                }
                else
                {
                    int sum=pref[i-1]+nums[i]+suf[i+1];
                    if(sum<result)
                    {
                        result=sum;
                    }
                }
            }
        }
        
        return result;
        
    }
}
