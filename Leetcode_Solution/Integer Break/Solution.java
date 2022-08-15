class Solution {
    public int integerBreak(int n) {
        int dp[]=new int[n+1];
        dp[0]=1;
        int max[]=new int[n+1];
        max[0]=0;
        max[1]=1;
        for(int i=1;i<=n;i++)
        {
            for(int j=i;j<=n;j++)
            {
                dp[j]+=dp[j-i];
                if(dp[j-i]>0)
                {
                    if(j-i==0)
                    {
                        if(i!=n)
                        {
                          if(max[j]<i)
                          {
                              max[j]=i;
                          }
                        }
                      
                    }
                    else
                    {
                        int x=i*max[j-i];
                        if(max[j]<x)
                        {
                            max[j]=x;
                        }
                    }
                }
            }
        }
        
        return max[n];
    }
}
