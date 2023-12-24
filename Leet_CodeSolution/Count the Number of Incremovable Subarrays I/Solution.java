class Solution {
    public int incremovableSubarrayCount(int[] nums) {
       int count=1;
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
            int ans=count;
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
            for(int i=0;i<=p;i++)
            {
                count=0;
                for(int j=nums.length-1;j>=q;j--)
                {
                    if(nums[i]<nums[j])
                    {
                        count++;
                    }
                    else
                    {
                        break;
                    }
                }
                ans+=count;
            }
            return ans+1;
            
        }
        
    }
}
