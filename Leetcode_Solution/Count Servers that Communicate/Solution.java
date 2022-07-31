class Solution {
    public int countServers(int[][] grid) {
        ArrayList<Integer> rowCount=new ArrayList<Integer>();
        ArrayList<Integer> colCount=new ArrayList<Integer>();
        for(int i=0;i<grid.length;i++)
        {
            int count=0;
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]==1)
                {
                    count++;
                }
            }
            rowCount.add(count);
        }
        for(int j=0;j<grid[0].length;j++)
        {
            int count=0;
            for(int i=0;i<grid.length;i++)
            {
                if(grid[i][j]==1)
                {
                    count++;
                }
            }
            colCount.add(count);
            
        }
        int result=0;
        for(int i=0;i<grid.length;i++)
         {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]==1)
                {
                    if(rowCount.get(i)>1 || colCount.get(j)>1)
                    {
                        result++;
                    }
                }
            }
        }
        
        
        return result;
    }
}
