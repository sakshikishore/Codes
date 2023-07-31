class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int LISpref[]=new int[nums.length];
        int LISsuf[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            LISpref[i]=1;
            for(int j=i-1;j>=0;j--)
            {
                if(nums[i]>nums[j])
                {
                    if(LISpref[j]+1>LISpref[i])
                    {
                       LISpref[i]= LISpref[j]+1;
                    }
                }
            }
        }
        for(int i=nums.length-1;i>=0;i--)
        {
            LISsuf[i]=1;
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]>nums[j])
                {
                    if(LISsuf[j]+1>LISsuf[i])
                    {
                       LISsuf[i]= LISsuf[j]+1;
                    }
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i<nums.length-1;i++)
        {
            if(LISsuf[i]!=1 && LISpref[i]!=1)
            {
              int p=LISsuf[i]+LISpref[i]-1;
              if(nums.length-p<min)
              {
                  min=nums.length-p;
              }
            }
        }

        return min;

    }
}
