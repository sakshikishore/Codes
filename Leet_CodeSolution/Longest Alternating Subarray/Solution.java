class Solution {
    public int alternatingSubarray(int[] nums) {
        int max=-1;
        for(int i=0;i<nums.length;i++)
        {
            int count=1;
            int p=0;
            for(int j=i+1;j<nums.length;j++)
            {
                if(p%2==0)
                {
                    if(nums[j]-nums[j-1]==1)
                    {
                        count++;
                    }
                    else
                    {
                        break;
                    }
                        
                }
                else
                {
                    if(nums[j]-nums[j-1]==-1)
                    {
                        count++;
                    }
                    else
                    {
                        break;
                    }
                }
                p++;
            }
            if(count>1)
            {
                if(count>max)
                {
                    max=count;
                }
            }
        }
        
        return max;
    }
}
