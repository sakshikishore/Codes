class Solution {
    long dp[][][]=new long[51][51][51];
    public long Solve(int m, int n, int maxMove, int startRow, int startColumn, long dp[][][])
    {
        if(startRow<0 || startRow>=m || startColumn<0 || startColumn>=n)
       {
          return 1L;
       }
       if(maxMove==0)
       {
           return 0;
       }
       if(dp[maxMove][startRow][startColumn]!=-1)
       {
           return dp[maxMove][startRow][startColumn];
       }
       long op1=Solve(m,n,maxMove-1,startRow+1,startColumn,dp);
       long op2=Solve(m,n,maxMove-1,startRow-1,startColumn,dp);
       long op3=Solve(m,n,maxMove-1,startRow,startColumn+1,dp);
       long op4=Solve(m,n,maxMove-1,startRow,startColumn-1,dp);
       return dp[maxMove][startRow][startColumn]=(op1+op2+op3+op4)%1000000007;
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
         for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                for(int k=0;k<dp[0][0].length;k++)
                {
                    dp[i][j][k]=-1L;
                }
            }
        }
       return (int)Solve(m,n,maxMove,startRow,startColumn,dp);
      
    }
}
