class Solution {
    public boolean checkXMatrix(int[][] grid) {
        boolean result=true;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(i==j)
                {
                    if(grid[i][j]==0)
                    {
                        result=false;
                        break;
                    }
                }
                else if(j==grid[i].length-1-i)
                {
                    if(grid[i][j]==0)
                    {
                        result=false;
                        break;
                    }
                }
                else if(grid[i][j]!=0)
                {
                    result=false;
                    break;
                }
                    
            }
            if(!result)
            {
                break;
            }
        }
        
        return result;
        
    }
}
