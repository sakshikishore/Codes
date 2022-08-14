class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n=grid.length;
        int result[][]=new int[n-2][n-2];
        for(int i=0;i<n-2;i++)
        {
            for(int j=0;j<n-2;j++)
            {
                int max=0;
                for(int x=i;x<i+3;x++)
                {
                    for(int y=j;y<j+3;y++)
                    {
                        if(grid[x][y]>max)
                        {
                            max=grid[x][y];
                        }
                    }
                }
                result[i][j]=max;
            }
        }
        
        return result;
    }
}
