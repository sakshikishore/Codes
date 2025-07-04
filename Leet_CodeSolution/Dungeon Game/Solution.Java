class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        for(int i=dungeon.length-1;i>=0;i--)
        {
            for(int j=dungeon[i].length-1;j>=0;j--)
            {
                if(i==dungeon.length-1 && j==dungeon[i].length-1)
                {
                    if(dungeon[i][j]>=0)
                    {
                        dungeon[i][j]=1;
                    }
                    else
                   {
                        dungeon[i][j]=1-dungeon[i][j];
                   }
                }
                else if(j==dungeon[i].length-1)
                {
                    if(dungeon[i][j]>=0)
                    {
                        if(dungeon[i][j]>=dungeon[i+1][j])
                        {
                            dungeon[i][j]=1;
                        }
                        else
                        {
                            dungeon[i][j]=dungeon[i+1][j]-dungeon[i][j];
                        }
                    }
                    else
                   {
                        dungeon[i][j]=(1-dungeon[i][j])+(dungeon[i+1][j]-1);
                   }
                }
                else if(i==dungeon.length-1)
                {
                    if(dungeon[i][j]>=0)
                    {
                        if(dungeon[i][j]>=dungeon[i][j+1])
                        {
                            dungeon[i][j]=1;
                        }
                        else
                        {
                            dungeon[i][j]=dungeon[i][j+1]-dungeon[i][j];
                        }
                    }
                    else
                   {
                        dungeon[i][j]=(1-dungeon[i][j])+(dungeon[i][j+1]-1);
                   }
                }
                else
                {
                    if(dungeon[i][j]>=0)
                    {
                       if((dungeon[i][j]>=dungeon[i+1][j]) ||(dungeon[i][j]>=dungeon[i][j+1]))
                       {
                        dungeon[i][j]=1;
                       }
                       else
                       {
                         int p=dungeon[i+1][j]-dungeon[i][j];
                         int q=dungeon[i][j+1]-dungeon[i][j];
                         dungeon[i][j]=Math.min(p,q);
                       }
                    }
                    else
                    {
                        int p=(1-dungeon[i][j])+(dungeon[i][j+1]-1);
                        int q=(1-dungeon[i][j])+(dungeon[i+1][j]-1);
                        dungeon[i][j]=Math.min(p,q);
                    }
                }
            }
        }

        return dungeon[0][0];
    }
}
