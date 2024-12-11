class Solution {
    public int Solve(int k, int prices[], int index, int dp[][])
    {
        
        if(k==0 || index>=prices.length-1)
        {
            return 0;
        }
        if(dp[k][index]!=-1)
        {
            return dp[k][index];
        }
        int score=0;
        score=Math.max(score,Solve(k,prices,index+1,dp));
        for(int i=index+1;i<prices.length;i++)
        {
          
             if(prices[i]>prices[index])
             { 
                score=Math.max(score,prices[i]-prices[index]+Solve(k-1,prices,i+1,dp));
             }
           
        }

     
        return dp[k][index]=score;

    }
    public int maxProfit(int k, int[] prices) {
        int dp[][]=new int[101][1001];
        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
     return Solve(k, prices,0,dp);
     
    }
}
