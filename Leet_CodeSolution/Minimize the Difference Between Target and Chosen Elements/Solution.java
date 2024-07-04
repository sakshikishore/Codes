class Solution {
    int min=Integer.MAX_VALUE;
    public void Solve(int[][] mat, int target,int dp[][],int row,int sum)
    {
          if(row==mat.length)
          {
            if(Math.abs(target-sum)<min)
            {
                min=Math.abs(target-sum);
            }
            return;
          }
          if(dp[row][sum]!=0)
          {
              return;
          }
          dp[row][sum]=1;
          for(int i=0;i<mat[row].length;i++)
          {
            
                Solve(mat,target,dp,row+1,sum+mat[row][i]);
            
          }

    }
    public int minimizeTheDifference(int[][] mat, int target) {
        int dp[][]=new int[mat.length][(70*70)+1];
        Solve(mat,target,dp,0,0);

        return min;
    }
}
