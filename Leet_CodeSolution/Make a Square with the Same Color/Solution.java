class Solution {
    public boolean canMakeSquare(char[][] grid) {
        for(int i=0;i<grid.length-1;i++)
        {
            for(int j=0;j<grid[0].length-1;j++)
            {
                int b=0,w=0;
                if(grid[i][j]=='B')
                {
                    b++;
                }
                else
                {
                    w++;
                }
                if(grid[i][j+1]=='B')
                {
                    b++;
                }
                else
                {
                    w++;
                }
                if(grid[i+1][j]=='B')
                {
                    b++;
                }
                else
                {
                    w++;
                }
                if(grid[i+1][j+1]=='B')
                {
                    b++;
                }
                else
                {
                    w++;
                }
                if(b==3 || b==4 || w==3 || w==4)
                {
                    return true;
                }
            }
        }

        return false;
    }
}
