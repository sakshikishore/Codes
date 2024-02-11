class Solution {
    
    int arr[]={-1,0,1};
    public int Solve(int grid[][],int row,int c1,int c2,int dp[][][])
    {
        if(row==grid.length)
        {
            return 0;
        }
        if(c1<0 || c1>=grid[0].length || c2<0 || c2>=grid[0].length)
        {
            return 0;
        }
        if(dp[row][c1][c2]!=-1)
        {
            return dp[row][c1][c2];
        }
        int maxSum=0;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
               maxSum=Math.max(maxSum,Solve(grid,row+1,c1+arr[i],c2+arr[j],dp));
            }
        }
        if(c1==c2)
        {
            maxSum+=grid[row][c1];
        }
        else
        {
            maxSum+=grid[row][c1]+grid[row][c2];
        }
       
        return dp[row][c1][c2]=maxSum;
    }
    public int cherryPickup(int[][] grid) {
        int dp[][][]=new int[71][71][71];
        for(int i=0;i<71;i++)
        {
            for(int j=0;j<71;j++)
            {
                for(int k=0;k<71;k++)
                {
                    dp[i][j][k]=-1;
                }
            }
        }
        return Solve(grid,0,0,grid[0].length-1,dp);
    }
}
