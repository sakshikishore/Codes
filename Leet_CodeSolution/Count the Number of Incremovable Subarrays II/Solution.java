class Solution {
    public long incremovableSubarrayCount(int[] nums) {
        long count=1;
        int p=0,q=nums.length-1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>nums[i-1])
            {
                count++;
                p++;
            }
            else
            {
                break;
            }
        }
        if(count==nums.length)
        {
            return ((count)*(count+1))/2;
        }
        else
        {
            long ans=count;
            count=1;
            for(int i=nums.length-2;i>=0;i--)
            {
                if(nums[i]<nums[i+1])
                {
                    count++;
                    q--;
                }
                else
                {
                    break;
                }
            }
            
            ans+=count;
            for(int i=p;i>=0;i--)
            {
                count=0;
                int flag=0;
                for(int j=nums.length-1;j>=q;j--)
                {
                    if(nums[i]<nums[j])
                    {
                        count++;
                    }
                    else
                    {
                        flag=1;
                        break;
                    }
                }
                if(flag==0)
                {
                    ans+=(i+1)*count;
                    break;
                }
                ans+=count;
            }
            return ans+1;
            
        }
        
    }
}
