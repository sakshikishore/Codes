class Solution {
    int dp[]=new int[100001];
    public int Solve(int n)
    {
        if(n<=0)
        {
            return 0;
        }
        if(dp[n]!=-1)
        {
            return dp[n];
        }
        for(int i=1;i*i<=n;i++)
        {
           if(Solve(n-(i*i))==0)
           {
               return dp[n]=1;
           }
        }
        return dp[n]=0;
    }
    public boolean winnerSquareGame(int n) {
            for(int i=0;i<dp.length;i++)
            {
                dp[i]=-1;
            }
            int x= Solve(n);
            if(x==0)
            {
                return false;
            }
            else
            {
                return true;
            }
        
    }
}
