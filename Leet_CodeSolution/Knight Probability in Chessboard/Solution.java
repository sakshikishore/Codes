class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        if(k==0)
        {
            double result=1.0;
            return result;
        }
       double dp[][][]=new double[k+1][n][n];
       dp[0][row][column]=1.0;
       for(int i=1;i<=k;i++)
       {
           for(int j=0;j<n;j++)
           {
              for(int l=0;l<n;l++)
              {
                  if(dp[i-1][j][l]!=0)
                  {
                     if(j+2<n && l+1<n)
                     {
                         dp[i][j+2][l+1]+=dp[i-1][j][l]*(1.0/8);
                     }
                     if(j+2<n && l-1>=0)
                     {
                          dp[i][j+2][l-1]+=dp[i-1][j][l]*(1.0/8);
                     }
                     if(j-2>=0 && l+1<n)
                     {
                         dp[i][j-2][l+1]+=dp[i-1][j][l]*(1.0/8);
                     }
                     if(j-2>=0 && l-1>=0)
                     {
                         dp[i][j-2][l-1]+=dp[i-1][j][l]*(1.0/8);
                     }
                     if(j-1>=0 && l+2<n)
                     {
                         dp[i][j-1][l+2]+=dp[i-1][j][l]*(1.0/8);
                     }
                     if(j+1<n && l+2<n)
                     {
                         dp[i][j+1][l+2]+=dp[i-1][j][l]*(1.0/8);
                     }
                     if(j-1>=0 && l-2>=0)
                     {
                         dp[i][j-1][l-2]+=dp[i-1][j][l]*(1.0/8);
                     }
                     if(j+1<n && l-2>=0)
                     {
                         dp[i][j+1][l-2]+=dp[i-1][j][l]*(1.0/8);
                     }
                  }
              }
           }
       }
       double result=0.0;
       for(int i=0;i<n;i++)
       {
           for(int j=0;j<n;j++)
           {
               result+=dp[k][i][j];
           }
       }

       return result;
    }
}
