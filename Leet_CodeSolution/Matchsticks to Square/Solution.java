class Solution {
    boolean result=false;
    public void Solve(int[] matchsticks, int k, int n, int dp[][],int total,int temp)
    {
        if(result)
        {
            return;
        }
        if(total==(4-k)*n)
        {
            k--;
            if(k==-1)
            {
                result=true;
                 return;
            }
            Solve(matchsticks,k,n,dp,total,temp);
            return;
        }
        if(dp[temp][k]!=0)
        {
            return;
        }
        dp[temp][k]=1;
        for(int i=0;i<matchsticks.length;i++)
        {
            if(matchsticks[i]!=-1)
            {
                if(matchsticks[i]+total<=(4-k)*n)
                {
                  int p=matchsticks[i];
                  matchsticks[i]=-1;
                  Solve(matchsticks,k,n,dp,total+p,temp+(int)Math.pow(2,i));
                  matchsticks[i]=p;
                }

            }
        }

    }
    public boolean makesquare(int[] matchsticks) {
        long sum=0;
        for(int i=0;i<matchsticks.length;i++)
        {
            sum+=matchsticks[i];
        }
        if(sum%4==0)
        {
          int s=0;
          for(int i=0;i<matchsticks.length;i++)
          {
            s+=Math.pow(2,i);
          }
          int dp[][]=new int[s+1][4];
          Solve(matchsticks,3,(int)sum/4,dp,0,0);
        }

        return result;
    }
}
