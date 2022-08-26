class Solution {
    public boolean canPartition(int[] nums) {
        boolean result=false;
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        if(sum%2==0)
        {
            int n=sum/2;
            int dp[][]=new int[nums.length][n+1];
            for(int i=0;i<nums.length;i++)
            {
                for(int j=0;j<=n;j++)
                {
                    if(i==0)
                    {
                        if(nums[i]==j)
                        {
                            dp[i][j]=1;
                        }
                    }
                    else
                    {
                        if(dp[i-1][j]==1)
                        {
                            dp[i][j]=1;
                        }
                        else if(nums[i]==j)
                        {
                            dp[i][j]=1;
                        }
                        else
                        {
                            if(j>nums[i])
                            {
                                if(dp[i-1][j-nums[i]]==1)
                                {
                                    dp[i][j]=1;
                                }
                            }
                        }
                    }
                    if(dp[i][n]==1)
                    {
                        return true;
                    }
                }
            }
        }
        
        return result;
    }
}
