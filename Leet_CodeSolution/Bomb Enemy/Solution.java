
class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int max=0;
        int rowleft[][]=new int[grid.length][grid[0].length];
        int rowright[][]=new int[grid.length][grid[0].length];
        int colTop[][]=new int[grid.length][grid[0].length];
        int colBottom[][]=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            int enemy=0;
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='W')
                { 
                    enemy=0;
                }
                else if(grid[i][j]=='E')
                {
                    enemy++;
                }
                rowleft[i][j]=enemy;
            }
        }
        for(int i=0;i<grid.length;i++)
        {
            int enemy=0;
            for(int j=grid[0].length-1;j>=0;j--)
            {
                if(grid[i][j]=='W')
                {
                   enemy=0;
                    
                }
                else if(grid[i][j]=='E')
                {
                    enemy++;
                }
                
                rowright[i][j]=enemy;
            }
        }
        for(int i=0;i<grid[0].length;i++)
        {
            int enemy=0;
            for(int j=0;j<grid.length;j++)
            {
                if(grid[j][i]=='W')
                {
                   enemy=0;
                    
                }
                else if(grid[j][i]=='E')
                {
                    enemy++;
                }
                colTop[j][i]=enemy;
            }
        }

        for(int i=0;i<grid[0].length;i++)
        {
            int enemy=0;
            for(int j=grid.length-1;j>=0;j--)
            {
                if(grid[j][i]=='W')
                {
                    enemy=0;
                    
                }
                else if(grid[j][i]=='E')
                {
                    enemy++;
                }
                colBottom[j][i]=enemy;
            }
        }
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]=='0')
                {
                   int totalEnemy=rowleft[i][j]+rowright[i][j]+colTop[i][j]+colBottom[i][j];
                   if(totalEnemy>max)
                   {
                    max=totalEnemy;
                   }
                }
            }
        }

        return max;

        
    }
}
