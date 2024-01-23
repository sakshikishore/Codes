class Solution {
    public int Solve(int stones[],int i,int j,int total,int [][]dp)
    {
        if(i>j)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int score1=total-stones[i]-Solve(stones,i+1,j,total-stones[i],dp);
        int score2=total-stones[j]-Solve(stones,i,j-1,total-stones[j],dp);

        return dp[i][j]=Math.max(score1,score2);        
        

    }
    public int stoneGameVII(int[] stones) {
        int total=0;
        int dp[][]=new int[1000][1000];
        for(int i=0;i<dp.length;i++)
        {
           Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<stones.length;i++)
        {
            total+=stones[i];
        }
        return Solve(stones,0,stones.length-1,total,dp);
    }
}
