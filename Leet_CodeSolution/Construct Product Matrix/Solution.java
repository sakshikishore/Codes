class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int result[][]=new int[grid.length][grid[0].length];
        int pref[][]=new int[grid.length][grid[0].length];
        long m=1;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                m=m*grid[i][j];
                m=m%(12345);
                pref[i][j]=(int)m;
            }
        }
        int suff[][]=new int[grid.length][grid[0].length];
        m=1;
        for(int i=grid.length-1;i>=0;i--)
        {
            for(int j=grid[i].length-1;j>=0;j--)
            {
                m=m*grid[i][j];
                m=m%(12345);
                suff[i][j]=(int)m;
            }
        }
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(i==0 && j==0)
                {
                   if(j+1<grid[0].length)
                   {
                       result[i][j]=suff[i][j+1];
                   }
                   else
                    {
                        if(i+1<grid.length)
                        {
                            result[i][j]=suff[i+1][0];
                        }
                    }
                }
                else if(i==grid.length-1 && j==grid[0].length-1)
                {
                    if(j-1>=0)
                    {
                        result[i][j]=pref[i][j-1];
                    }
                    else
                    {
                        result[i][j]=pref[i-1][grid[0].length-1];
                    }
                }
                else
                {
                    long p=1;
                    if(j+1<grid[0].length)
                   {
                       p=p*suff[i][j+1];
                   }
                   else
                    {
                        if(i+1<grid.length)
                        {
                           p=p*suff[i+1][0];
                        }
                    }
                     if(j-1>=0)
                    {
                        result[i][j]=(int)(p*pref[i][j-1])%(12345);
                    }
                    else
                    {
                        result[i][j]=(int)(p*pref[i-1][grid[0].length-1])%12345;
                    }
                }
            }
        }

        return result;

    }
}
