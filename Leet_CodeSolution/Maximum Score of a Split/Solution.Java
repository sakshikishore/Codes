class Solution {
    public long maximumScore(int[] nums) {
        long max=Long.MIN_VALUE;
        long pref[]=new long[nums.length];
        int sufMin[]=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--)
        {
            if(i==nums.length-1)
            {
                sufMin[i]=nums[i];
            }
            else
            {
                if(nums[i]<sufMin[i+1])
                {
                    sufMin[i]=nums[i];
                }
                else
                {
                    sufMin[i]=sufMin[i+1];
                }
            }
        }
        for(int i=0;i<nums.length-1;i++)
        {
            if(i==0)
            {
                pref[i]=nums[i]*1l;
            }
            else
            {
                pref[i]=pref[i-1]+nums[i];
            }
            max=Math.max(pref[i]-sufMin[i+1],max);
        }

        return max;
    }
}
