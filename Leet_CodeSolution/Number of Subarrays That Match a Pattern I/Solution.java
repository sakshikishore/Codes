class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
            int count=0;
            for(int j=0;j<nums.length-pattern.length;j++)
            {
                int flag=0;
                for(int i=0;i<pattern.length;i++)
                {
                    if(pattern[i]==1)
                    {
                        if(nums[j+1+i]<=nums[j+i])
                        {
                            flag=1;
                            break;
                        }
                    }
                    else if(pattern[i]==0)
                    {
                        if(nums[j+1+i]!=nums[j+i])
                        {
                            flag=1;
                            break;
                        }
                    }
                    else
                    {
                        if(nums[j+1+i]>=nums[j+i])
                        {
                            flag=1;
                            break;
                        }
                    }
                }
                if(flag==0)
                {
                    count++;
                }
                
            }
        
        return count;
        
    }
}
