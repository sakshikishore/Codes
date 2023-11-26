class Solution {
    public int minimumCoins(int[] prices) {
        int dp[]=new int[prices.length];
        dp[dp.length-1]=prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--)
        {
            if(i+i+2>=prices.length)
            {
                dp[i]=prices[i];
            }
            else
            {
                int min=Integer.MAX_VALUE;
                for(int j=i+1;j<=(i+i+2);j++)
                {
                     if(dp[j]<min)
                     {
                         min=dp[j];
                     }
                }

                dp[i]=min+prices[i];
            }
        }
        return dp[0];
    }
}
