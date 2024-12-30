class Solution {
    public int minimumOperations(int[][] grid) {
        int result=0;
        for(int i=0;i<grid[0].length;i++)
        {
            int count=grid[0][i];
            for(int j=1;j<grid.length;j++)
            {
                count++;
                if(grid[j][i]>count)
                {
                    count=grid[j][i];
                }
                else
                {
                    result+=count-grid[j][i];
                }
            }
        }

        return result;
    }
}
