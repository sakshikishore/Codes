class Solution {
    public int maximumLength(int[] nums, int k) {
        int dp[][]=new int[nums.length][k+1];
        dp[0][0]=1;
        int max=1;
        for(int i=1;i<nums.length;i++)
        {
          for(int j=i-1;j>=0;j--)
          {
            if(nums[i]==nums[j])
            {
                for(int t=0;t<=k;t++)
                {
                    dp[i][t]=Math.max(dp[i][t],dp[j][t]+1);
                    if(dp[i][t]>max)
                    {
                        max=dp[i][t];
                    }
                }
            }
            else
            {
                dp[i][0]=Math.max(dp[i][0],1);
                for(int t=0;t<k;t++)
                {
                    dp[i][t+1]=Math.max(dp[i][t+1],dp[j][t]+1);
                    if(dp[i][t+1]>max)
                    {
                        max=dp[i][t+1];
                    }
                }
            }
          }
        }

        return max;
    }
}
