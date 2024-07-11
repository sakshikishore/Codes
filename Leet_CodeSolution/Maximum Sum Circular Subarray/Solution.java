class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int prefMax[]=new int[nums.length];
        int suf[]=new int[nums.length];
        int sum=nums[0],max=nums[0];
        prefMax[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            sum+=nums[i];
            if(sum>max)
            {
               max=sum;
            }
            prefMax[i]=max;
        }
        suf[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--)
        {
           
            suf[i]=nums[i]+suf[i+1];
        }
        sum=0;
        max=nums[0];
        for(int i=0;i<nums.length;i++)
        {
             if(sum+nums[i]>0)
             {
                if(sum+nums[i]>nums[i])
                {
                sum=sum+nums[i];
                }
                else
                {
                    sum=nums[i];
                }
             }
             else
             {
                sum=nums[i];
             }
             if(i!=0)
                {
                    int p=prefMax[i-1]+suf[i];
                    p=Math.max(p,sum);
                    if(p>max)
                    {
                        max=p;
                    }
                }
                else
                {
                    if(sum>max)
                    {
                        max=sum;
                    }
                }
        }

        return max;

    }
}
