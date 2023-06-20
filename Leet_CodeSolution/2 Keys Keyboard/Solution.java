class Solution {
    public int minSteps(int n) {
        int dp[]=new int[n+1];
        for(int i=2;i<=n;i++)
        {
            if(i%2==0)
            {
                dp[i]=dp[i/2]+2;
            }
            else
            {
                dp[i]=i;
                int x=i/2;
                for(int j=x;j>=2;j--)
                {
                    if(i%j==0)
                    {
                        dp[i]=dp[j]+(i/j);
                        break;
                    }
                }
            }
        }

        return dp[n];
    }
}
