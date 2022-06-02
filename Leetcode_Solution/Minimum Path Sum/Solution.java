class Solution {
    public int minPathSum(int[][] grid) {
        int arr[][]=new int[grid.length][grid[0].length];
        for(int i=grid.length-1;i>=0;i--)
        {
            for(int j=grid[0].length-1;j>=0;j--)
            {
                if(i==grid.length-1)
                {
                   if(j==grid[0].length-1)
                   {
                       arr[i][j]=grid[i][j];
                   }
                   else
                    {
                        arr[i][j]=arr[i][j+1]+grid[i][j];
                    }
                    
                }
                else
                {
                    if(j==grid[0].length-1)
                    {
                       arr[i][j]=grid[i][j]+arr[i+1][j];
                    }
                    else
                    {
                        arr[i][j]=Math.min(arr[i][j+1],arr[i+1][j])+grid[i][j];
                    }
                }
            }
        }
        
        int result=arr[0][0];
        
        return result;
    }
}
