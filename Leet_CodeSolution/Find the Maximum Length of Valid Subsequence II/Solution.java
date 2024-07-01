class Solution {
    public int maximumLength(int[] nums, int k) {
        int dp[][]=new int[nums.length][k];
        int max=0;
        for(int i=1;i<nums.length;i++)
        {
             for(int j=i-1;j>=0;j--)
             {
                int r=(nums[i]+nums[j])%k;
                if(dp[j][r]+1>dp[i][r])
                {
                    dp[i][r]=dp[j][r]+1;
                    if(dp[i][r]>max)
                    {
                        max=dp[i][r];
                    }
                }
             }
        }

        return max+1;
    }
}
