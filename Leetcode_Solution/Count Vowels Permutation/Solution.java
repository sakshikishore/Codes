class Solution {
    public int countVowelPermutation(int n) {
        if(n==1)
        {
            return 5;
        }
        long dp[][]=new long[n][5];
        for(int i=0;i<5;i++)
        {
            dp[0][i]=1;
        }
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<5;j++)
            {
                if(j==0)
                {
                    dp[i][j]=dp[i-1][1]+dp[i-1][2]+dp[i-1][4];
                }
                else if(j==1)
                {
                    dp[i][j]=dp[i-1][0]+dp[i-1][2];
                }
                else if(j==2)
                {
                    dp[i][j]=dp[i-1][1]+dp[i-1][3];
                }
                else if(j==3)
                {
                    dp[i][j]=dp[i-1][2];
                }
                else
                {
                    dp[i][j]=dp[i-1][3]+dp[i-1][2];
                }
                dp[i][j]=dp[i][j]%(1000000007);
            }
        }
        long sum=0;
        for(int i=0;i<5;i++)
        {
            sum+=dp[n-1][i];
            sum=sum%(1000000007);
        }
        
        
        return (int)sum;
    }
}
