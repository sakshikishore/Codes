class Solution {
    int max=0;
    public void Solve(int grid[][],int i,int j,int score)
    {
        if(score>max)
        {
            max=score;
        }
        if(i<0 || i>grid.length-1 || j<0 || j>grid[0].length-1 || grid[i][j]==-1 || grid[i][j]==0)
        {
            return;
        }
        int temp=grid[i][j];
        grid[i][j]=-1;
         Solve(grid,i-1,j,score+temp);
         Solve(grid,i+1,j,score+temp);
         Solve(grid,i,j-1,score+temp);
         Solve(grid,i,j+1,score+temp);
         
        grid[i][j]=temp;

    }
    public int getMaximumGold(int[][] grid) {
        for(int i=0;i<grid.length;i++)
        {
           for(int j=0;j<grid[0].length;j++)
           {
               if(grid[i][j]!=0)
               {
                     Solve(grid,i,j,0);
               }
           }
        }

        return max;
    }
}
