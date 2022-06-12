class Solution {
    public int minFallingPathSum(int[][] grid) {
        int arr[][]=new int[grid.length][grid[0].length];
        int result=Integer.MAX_VALUE;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(i==0)
                {
                    arr[i][j]=grid[i][j];
                    if(i==grid.length-1)
                    {
                        if(arr[i][j]<result)
                        {
                            result=arr[i][j];
                        }
                    }
                }
                else
                {
                    int min=Integer.MAX_VALUE;
                    for(int k=0;k<grid[0].length;k++)
                    {
                        if(k!=j)
                        {
                            if(arr[i-1][k]<min)
                            {
                                min=arr[i-1][k];
                            }
                        }
                    }
                    arr[i][j]=grid[i][j]+min;
                    if(i==grid.length-1)
                    {
                        if(arr[i][j]<result)
                        {
                            result=arr[i][j];
                        }
                    }
                }
            }
        }
        
        
         
        
        return result;
    }
}
