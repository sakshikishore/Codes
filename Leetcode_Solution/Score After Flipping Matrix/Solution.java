class Solution {
    public int matrixScore(int[][] grid) {
        int result=0;
        for(int i=0;i<grid.length;i++)
        {
            if(grid[i][0]==0)
            {
                for(int j=0;j<grid[i].length;j++)
                {
                    if(grid[i][j]==0)
                    {
                        grid[i][j]=1;
                    }
                    else
                    {
                        grid[i][j]=0;
                    }
                }
            }
        }
        
        for(int i=1;i<grid[0].length;i++)
        {
            int a=0,b=0;
            for(int j=0;j<grid.length;j++)
            {
                if(grid[j][i]==1)
                {
                    a++;
                }
                else
                {
                    b++;
                }
            }
            if(a<b)
            {
                for(int j=0;j<grid.length;j++)
                {
                    if(grid[j][i]==1)
                    {
                        grid[j][i]=0;
                    }
                    else
                    {
                        grid[j][i]=1;
                    }
                }
            }
        }
        
        for(int i=0;i<grid.length;i++)
        {
            int p=0,k=0;
            for(int j=grid[i].length-1;j>=0;j--)     
            {
                p=p+(((int)Math.pow(2,k))*grid[i][j]);
                k++;
            }
            result+=p;
        }
        
        return result;
        
    }
}
