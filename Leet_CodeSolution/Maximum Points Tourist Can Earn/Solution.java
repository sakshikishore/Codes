class Solution {
    int result=0;
    int dp[][]=new int[201][201];
    public int Solve(int k, int[][] stayScore, int[][] travelScore,int day,int curCity)
    {
        if(day==k)
        {
            return 0;
        }
        if(dp[day][curCity]!=-1)
        {
            return dp[day][curCity];
        }
        int max=0;
        if(day==0)
        {
              for(int i=0;i<stayScore[0].length;i++)
              {
              max=Math.max(max,stayScore[0][i]+Solve(k,stayScore,travelScore,day+1,i));
              }
              for(int i=0;i<travelScore.length;i++)
              {
                for(int j=0;j<travelScore[0].length;j++)
                {
                    if(travelScore[i][j]!=0)
                    {
                        max=Math.max(max,travelScore[i][j]+Solve(k,stayScore,travelScore,day+1,j));
                    }
                }
              }
        }
        else
        {
            max=Math.max(max,stayScore[day][curCity]+Solve(k,stayScore,travelScore,day+1,curCity));
            for(int j=0;j<travelScore[0].length;j++)
                {
                    if(j!=curCity)
                    {
                        max=Math.max(max,travelScore[curCity][j]+Solve(k,stayScore,travelScore,day+1,j));
                    }
                }
        }

        return dp[day][curCity]=max;

    }
    public int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return Solve(k,stayScore,travelScore,0,0);
    }
}
