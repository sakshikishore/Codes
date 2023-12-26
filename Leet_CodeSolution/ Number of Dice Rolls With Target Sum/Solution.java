class Solution {
    public long Solve(int n,int k, int target, long dp[][])
    {
        if(target<0)
        {
            return 0;
        }
        if(n==0 && target!=0)
        {
            return 0;
        }
        if(target==0 && n!=0)
        {
            return 0;
        }
        if(target==0 && n==0)
        {
            return 1;
        }
        if(dp[n][target]!=-1)
        {
            return dp[n][target];
        }
        long res=0;
        for(int i=1;i<=k;i++)
        {
            res+=Solve(n-1,k,target-i,dp);
        }

        return dp[n][target]=res%(1000000007);
    }
    public int numRollsToTarget(int n, int k, int target) {
        long dp[][]=new long[n+1][target+1];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                dp[i][j]=-1;
            }
        }
        return (int)Solve(n,k,target,dp);
    }
}
