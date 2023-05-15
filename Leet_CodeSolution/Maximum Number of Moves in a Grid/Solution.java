class Solution {
    public int maxMoves(int[][] grid) {
        int arr[][]=new int[grid.length][grid[0].length];
        for(int i=grid[0].length-1;i>0;i--)
        {
            for(int j=0;j<grid.length;j++)
            {
                if(j-1>=0)
                {
                    if(grid[j-1][i-1]<grid[j][i])
                    {
                        if(arr[j-1][i-1]<arr[j][i]+1)
                        {
                            arr[j-1][i-1]=arr[j][i]+1;
                        }
                    }
                }
                 if(grid[j][i-1]<grid[j][i])
                    {
                        if(arr[j][i-1]<arr[j][i]+1)
                        {
                            arr[j][i-1]=arr[j][i]+1;
                        }
                    }
                 if(j+1<grid.length)
                 {
                     if(grid[j+1][i-1]<grid[j][i])
                    {
                        if(arr[j+1][i-1]<arr[j][i]+1)
                        {
                            arr[j+1][i-1]=arr[j][i]+1;
                        }
                    }
                 }
            }
        }
        int max=0;
        for(int j=0;j<arr.length;j++)
        {
            if(arr[j][0]>max)
            {
                max=arr[j][0];
            }
        }
        
        return max;
    }
}
