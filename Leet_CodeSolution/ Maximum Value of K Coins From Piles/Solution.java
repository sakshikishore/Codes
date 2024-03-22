class Solution {
  
    int dp[][]=new int[1001][2001];

    public int Solve(List<List<Integer>> piles, int k, int i,int dp[][])
    {
        if(k==0 || i>=piles.size())
        {
           return 0;
        }
        if(dp[i][k]!=-1)
        {
            return dp[i][k];
        }
        int s=0;
        int max= Solve(piles,k,i+1,dp);
        for(int j=0;j<piles.get(i).size();j++)
        {
            if(k-(j+1)>=0)
            {
                s+=piles.get(i).get(j);
        
                max=Math.max(max,s+Solve(piles,k-(j+1),i+1,dp));
            }
            else
            {
                break;
            }
        }

        return dp[i][k]=max;
    }
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int arr[]=new int[piles.size()];
        for(int i=0;i<dp.length;i++)
        {
            for(int j=0;j<dp[0].length;j++)
            {
                dp[i][j]=-1;
            }
        }
        return Solve(piles,k,0,dp);
    }
}
