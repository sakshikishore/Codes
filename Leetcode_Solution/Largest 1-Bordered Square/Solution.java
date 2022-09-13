class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int maxSide=Math.min(grid.length,grid[0].length);
        for(int i=maxSide;i>=1;i--)
        {
            for(int j=0;j<=grid.length-i;j++)
            {
                for(int k=0;k<=grid[0].length-i;k++)
                {
                    int flag=0;
                    for(int row=j;row<j+i;row++)
                    {
                        if(grid[row][k]!=1)
                        {
                            flag=1;
                            break;
                        }
                        if(grid[row][k+i-1]!=1)
                        {
                            flag=1;
                            break;
                        }
                    }
                    if(flag==0)
                    {
                        for(int col=k;col<k+i;col++)
                        {
                            if(grid[j][col]!=1)
                            {
                                flag=1;
                                break;
                            }
                            if(grid[j+i-1][col]!=1)
                            {
                                flag=1;
                                break;
                            }
                        }
                    }
                    if(flag==0)
                    {
                        return i*i;
                    }
                   
                }
            }
        }
        
        return 0;
    }
}
