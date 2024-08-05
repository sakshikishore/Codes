class Solution {
    public int minFlips(int[][] grid) {
        int count1=0,count2=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length/2;j++)
            {
                if(grid[i][j]!=grid[i][grid[i].length-1-j])
                {
                    count1++;
                }
            }
        }
        for(int i=0;i<grid[0].length;i++)
        {
            for(int j=0;j<grid.length/2;j++)
            {
                if(grid[j][i]!=grid[grid.length-1-j][i])
                {
                    count2++;
                }
            }
        }

        return Math.min(count1,count2);


    }
}
