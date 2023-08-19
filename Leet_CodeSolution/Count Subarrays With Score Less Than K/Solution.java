class Solution {
    public long countSubarrays(int[] nums, long k) {
        long ans=0;
        long sum=0;
        int start=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if((sum*(i-start+1))<k)
            {
                   ans+=i-start+1;
            }
            else
            {
                for(int j=start;j<=i;j++)
                {
                    sum=sum-nums[j];
                    start++;
                    if((sum*(i-start+1))<k)
                    {
                        ans+=i-start+1;
                        break;
                    }
                }
            }

        }

        return ans;
    }
}
