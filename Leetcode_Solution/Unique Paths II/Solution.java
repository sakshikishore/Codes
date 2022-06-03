class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int flag1=0,flag2=0;
        for(int i=obstacleGrid.length-1;i>=0;i--)
        {
            for(int j=obstacleGrid[0].length-1;j>=0;j--)
            {
               if(obstacleGrid[i][j]==1)
               {
                   obstacleGrid[i][j]=-1;
               }
            }
        }
        
        for(int i=obstacleGrid.length-1;i>=0;i--)
        {
            for(int j=obstacleGrid[0].length-1;j>=0;j--)
            {
                if(i==obstacleGrid.length-1)
                {
                    if(obstacleGrid[i][j]!=-1 && flag1==0)
                       {
                           obstacleGrid[i][j]=1;
                       }
                       else
                       {
                           if(i==obstacleGrid.length-1 && j==obstacleGrid[0].length-1)
                           {
                               flag2=1;
                           }
                           flag1=1;
                       }
                }
                else if(j==obstacleGrid[0].length-1)
                {
                    if(obstacleGrid[i][j]!=-1 && flag2==0)
                       {
                           obstacleGrid[i][j]=1;
                       }
                       else
                       {
                           flag2=1;
                           
                       }
                }
                else
                {
                    if(obstacleGrid[i][j]!=-1)
                    {
                        
                        if(obstacleGrid[i+1][j]!=-1)
                        {
                            obstacleGrid[i][j]=obstacleGrid[i+1][j];
                        }
                         if(obstacleGrid[i][j+1]!=-1)
                        {
                            obstacleGrid[i][j]+=obstacleGrid[i][j+1];
                        }
                    }
                }

            }
        }
        
        if(obstacleGrid[0][0]==-1)
        {
            obstacleGrid[0][0]=0;
        }
        return obstacleGrid[0][0];
        
    }
}
