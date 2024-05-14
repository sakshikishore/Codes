class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        long result=0;
      int c[]=new int[grid[0].length];
      int r[]=new int[grid.length];
      for(int i=0;i<grid[0].length;i++)
      {
          for(int j=0;j<grid.length;j++)
          {
            c[i]+=grid[j][i];
          }
      }
      for(int i=0;i<grid.length;i++)
      {
          for(int j=0;j<grid[0].length;j++)
          {
            r[i]+=grid[i][j];
          }
      }
      for(int i=0;i<grid.length;i++)
      {
        for(int j=0;j<grid[0].length;j++)
        {
            if(grid[i][j]==1)
            {
                if(c[j]>1 && r[i]>1)
                {
                    result+=(c[j]-1)*(r[i]-1);
                }
            }
        }
      }

      return result;
    }
}
