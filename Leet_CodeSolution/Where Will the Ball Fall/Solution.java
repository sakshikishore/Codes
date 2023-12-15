class Solution {
    public int[] findBall(int[][] grid) {
        int result[]=new int[grid[0].length];
        for(int j=0;j<grid[0].length;j++)
        {
           int currPosition=j;
           int nextPosition=j;
            for(int i=0;i<grid.length;i++)
            {
                nextPosition=currPosition+grid[i][nextPosition];
                if(nextPosition>=grid[0].length || nextPosition<0)
                {
                     currPosition=-1;
                    break;
                }
                else if(grid[i][nextPosition]!=grid[i][currPosition])
                {
                     currPosition=-1;
                    break;
                }
                currPosition=nextPosition;
            }
            result[j]= currPosition;
        }

        return result;
        
    }
}
