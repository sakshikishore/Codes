class Solution {
    public int numSquares(int n) {
        int dp[]=new int[n+1];
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            int j=1;
            int min=Integer.MAX_VALUE;
            while(i-(j*j)>=0)
            {
                if(dp[i-(j*j)]+1<min)
                {
                    min=dp[i-(j*j)]+1;
                }
                 j++;
            }
            dp[i]=min;
        }
        
        return dp[n];
    }
}
