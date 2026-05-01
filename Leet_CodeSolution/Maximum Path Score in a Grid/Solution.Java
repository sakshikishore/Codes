class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int result[][][]=new int[grid.length][grid[0].length][k+1];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                Arrays.fill(result[i][j],-2);
            }
        }
        int p=0;
        for(int i=grid.length-1;i>=0;i--)
        {
            for(int j=grid[0].length-1;j>=0;j--)
            {
                if(i==grid.length-1)
                {
                    if(j==grid[0].length-1)
                    {
                        if(grid[i][j]==1 || grid[i][j]==2)
                        {
                            p=1;
                            if(p<=k)
                            {
                            result[i][j][1]=grid[i][j];
                            }
                            else
                            {
                               return -1;
                            }
                        }
                        else
                        {
                            result[i][j][0]=0;
                        }
                    }
                    else
                    {
                        if(grid[i][j]==1 || grid[i][j]==2)
                        {
                            p++;
                            if(p<=k)
                            {
                              result[i][j][p]=grid[i][j]+result[i][j+1][p-1];
                            }
                            else
                            {
                                result[i][j][0]=-1;
                            }
                        }

                        else
                        {
                            if(result[i][j+1][0]==-1)
                            {
                                result[i][j][0]=-1;
                            }
                            else
                            {
                                result[i][j][p]=result[i][j+1][p]+grid[i][j];
                            }
                        }
                    }
                }
                else if(j==grid[0].length-1)
                {
                    if(i+1==grid.length-1)
                    {
                        p=0;
                        if(grid[i+1][j]==1 || grid[i+1][j]==2)
                        {
                            p=1;
                        }
                       if(grid[i][j]>0)
                       {
                          p++;
                          if(p<=k)
                          {
                             result[i][j][p]=grid[i][j]+result[i+1][j][p-1];
                          }
                          else
                          {
                            result[i][j][0]=-1;
                          }
                       }
                       else
                       {
                          result[i][j][p]=result[i+1][j][p];
                       }
                    }
                    else
                    {
                        if(result[i+1][j][0]==-1)
                        {
                            result[i][j][0]=-1;
                        }
                        else
                        {
                            if(grid[i][j]>0)
                            {
                                p++;
                                if(p<=k)
                                {
                                    result[i][j][p]=grid[i][j]+result[i+1][j][p-1];
                                }
                                else
                                {
                                    result[i][j][0]=-1;
                                }        
                            }
                            else
                            {
                               if(result[i+1][j][0]==-1)
                                {
                                    result[i][j][0]=-1;
                                }
                                else
                                {
                                    result[i][j][p]=grid[i][j]+result[i+1][j][p];
                                }
                            }
                        }
                    }

                }
                else
                {
                    if(result[i+1][j][0]==-1 && result[i][j+1][0]==-1)
                    {
                        result[i][j][0]=-1;
                    }
                    else
                    {
                        if(result[i+1][j][0]!=-1 && result[i][j+1][0]!=-1)
                        {
                            if(grid[i][j]==0)
                            {
                                for(int x=0;x<=k;x++)
                                {
                                    result[i][j][x]=Math.max(result[i+1][j][x],result[i][j+1][x]);
                                }
                            }
                            else
                            {
                                for(int x=1;x<=k;x++)
                                {
                                   if(result[i+1][j][x-1]==-2 && result[i][j+1][x-1]==-2)
                                   {
                                      continue;
                                   }
                                   else if(result[i+1][j][x-1]==-2)
                                   {
                                     result[i][j][x]=grid[i][j]+result[i][j+1][x-1];
                                   }
                                   else if(result[i][j+1][x-1]==-2)
                                   {
                                     result[i][j][x]=grid[i][j]+result[i+1][j][x-1];
                                   }
                                   else
                                   {
                                    result[i][j][x]=Math.max(result[i+1][j][x-1], result[i][j+1][x-1])+grid[i][j];
                                   }
                                }
                            }
                        }
                    }
                }
            }
        }

        int max=-1;

        if(result[0][0][0]==-1)
        {
            return -1;
        }
        else
        {
            for(int i=0;i<=k;i++)
            {
                if(result[0][0][i]>max)
                {
                    max=result[0][0][i];
                }
            }
        }
        

        return max;
    }
}
