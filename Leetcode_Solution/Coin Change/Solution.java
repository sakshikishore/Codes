class Solution {
    public int coinChange(int[] coins, int amount) {
        int arr[]=new int[amount+1];
        for(int i=1;i<arr.length;i++)
        {
            arr[i]=10001;
        }
        arr[0]=0;
        int dp[]=new int[amount+1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++)
        {
            for(int j=coins[i];j<=amount;j++)
            {
                dp[j]+=dp[j-coins[i]];
                if(dp[j-coins[i]]>0)
                {
                    if(arr[j]>arr[j-coins[i]]+1)
                    {
                        arr[j]=arr[j-coins[i]]+1;
                    }
                }
            }
        }
        if(arr[amount]==10001)
        {
            arr[amount]=-1;
        }
        return arr[amount];
    }
}
