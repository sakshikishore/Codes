class Solution {
    public long minCost(int m, int n, int[][] waitCost) {
        long grid[][] = new long[m][n];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                 if(i==grid.length-1 && j==grid[i].length-1)
                 {
                     grid[i][j]=(i+1l)*(j+1l);
                     if(i==0 && j==0)
                     {
                         return 1;
                     }
                 }
                 else if(i==0 && j==0)
                 {
                     long x=0;
                     if(i+1<grid.length)
                     {
                         x=1+grid[i+1][j];
                         if(j+1<grid[0].length)
                         {
                            x=Math.min(x,1+grid[i][j+1]);
                         }
                     }
                     else
                     {
                       x=1+grid[i][j+1];
                     }
                     return x;
                 }
                 else if(i==grid.length-1)
                 {
                    
                         grid[i][j]=((i+1l)*(j+1l))+grid[i][j+1]+waitCost[i][j];
                     
                 }
                else if(j==grid[0].length-1)
                {
                    
                         grid[i][j]=((i+1l)*(j+1l))+grid[i+1][j]+waitCost[i][j];
                     
                }
                else
                {
                    grid[i][j]=((i+1l)*(j+1l))+grid[i][j+1]+waitCost[i][j];
                    grid[i][j]=Math.min(grid[i][j],((i+1l)*(j+1l))+grid[i+1][j]+waitCost[i][j]);
    
                
                }
            }
        }
        return 0;
    }
}
