class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int ans=-1;
        for(int i=1;i<=nums.length;i++)
        {
            int count=0;
            for(int j=nums.length-1;j>=0;j--)
            {
                if(nums[j]>=i)
                {
                    count++;
                    if(count>i)
                    {
                        break;
                    }
                }
            }
            if(count==i)
            {
                ans=i;
                break;
            }
        }
        
        return ans;
    }
}
