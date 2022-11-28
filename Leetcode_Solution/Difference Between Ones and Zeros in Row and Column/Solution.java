class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int row_0[]=new int[grid.length];
        int row_1[]=new int[grid.length];
        int col_0[]=new int[grid[0].length];
        int col_1[]=new int[grid[0].length];
        int result[][]=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            int ones=0,zeros=0;
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    ones++;
                }
                else
                {
                    zeros++;
                }
            }
            row_0[i]=zeros;
            row_1[i]=ones;
        }
        for(int i=0;i<grid[0].length;i++)
        {
            int ones=0,zeros=0;
            for(int j=0;j<grid.length;j++)
            {
                if(grid[j][i]==1)
                {
                    ones++;
                }
                else
                {
                    zeros++;
                }
            }
            col_0[i]=zeros;
            col_1[i]=ones;
        }
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                result[i][j]=row_1[i]+col_1[j]-row_0[i]-col_0[j];
            }
        }
        
        return result;
        
    }
}
