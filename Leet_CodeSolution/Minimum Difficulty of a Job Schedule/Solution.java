class Solution {
    int dp[][]=new int[301][11];
    public int Solve(int[] jobDifficulty, int d, int start, int n,int dp[][])
    {
        if(d==1)
        {
           int max=0;
            for(int i=start;i<n;i++)
            {
                if(max<jobDifficulty[i])
                {
                    max=jobDifficulty[i];
                }
            }
            return max; 
        }
        if(dp[start][d]!=-1)
        {
            return dp[start][d];
        }
        int res=Integer.MAX_VALUE;
        int curr=Integer.MIN_VALUE;
        for(int j=start;j<=n-d;j++)
        {
           curr=Math.max(curr,jobDifficulty[j]);
           res=Math.min(res,curr+Solve(jobDifficulty,d-1,j+1,n,dp));
        }

        return dp[start][d]=res;

    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty.length<d)
        {
            return -1;
        }
        if(jobDifficulty.length==d)
        {
            int sum=0;
            for(int i=0;i<jobDifficulty.length;i++)
            {
                sum+=jobDifficulty[i];
            }
            return sum;
        }
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                dp[i][j]=-1;
            }
        }
        
        return Solve(jobDifficulty, d, 0, jobDifficulty.length,dp);
    }
}
