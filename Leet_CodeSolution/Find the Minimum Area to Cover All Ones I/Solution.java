class Solution {
    public int minimumArea(int[][] grid) {
        int x1=1000,x2=0,y1=1000,y2=0,flag=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    flag=1;
                    if(x1>i)
                    {
                        x1=i;
                    }
                    if(x2<i)
                    {
                        x2=i;
                    }
                    if(y1>j)
                    {
                        y1=j;
                    }
                    if(y2<j)
                    {
                        y2=j;
                    }
                }
            }
            
        }
        if(flag==0)
        {
            return 0;
        }
        return ((x2-x1)+1)*((y2-y1)+1);
    }
}
