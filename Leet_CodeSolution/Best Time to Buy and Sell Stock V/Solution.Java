class Solution {
    public long Solve(int[] prices,int i, int k,long dp[][])
    {
        if(k==0 || i==prices.length)
        {
            return 0;
        }
        if(dp[k][i]!=-1l)
        {
            return dp[k][i];
        }
        dp[k][i]=Math.max(0,Solve(prices,i+1,k,dp));
             int max1=0,max2=0;
             for(int j=i+1;j<prices.length;j++)
             {
                if(prices[j]-prices[i]>max1)
                {
                    max1=prices[j]-prices[i];
                   dp[k][i]=Math.max(dp[k][i],Solve(prices,j+1,k-1,dp)+(prices[j]*1l)-prices[i]);
                }
                if(prices[i]-prices[j]>max2)
                {
                    max2=prices[i]-prices[j];
                    dp[k][i]=Math.max(dp[k][i],(prices[i]*1l)-prices[j]+Solve(prices,j+1,k-1,dp));
                }
             }

        return dp[k][i];
        
    }

    public long maximumProfit(int[] prices, int k) {
        long dp[][] = new long[k+1][prices.length];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1l);
        }
        return Solve(prices, 0, k, dp);
    }
}
