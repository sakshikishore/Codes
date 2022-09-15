class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int arr[][]=new int[grid.length][grid[0].length];
        for(int i=arr.length-1;i>=0;i--)
        {
            for(int j=arr[0].length-1;j>=0;j--)
            {
                if(i==arr.length-1)
                {
                    arr[i][j]=grid[i][j];
                }
                else
                {
                    int min=Integer.MAX_VALUE;
                    int a=grid[i][j];
                    for(int k=0;k<arr[0].length;k++)
                    {
                        int x=arr[i+1][k]+a+moveCost[a][k];
                        if(x<min)
                        {
                            min=x;
                        }
                    }
                    
                    arr[i][j]=min;
                }
            }
        }
        int result=Integer.MAX_VALUE;
        for(int i=0;i<arr[0].length;i++)
        {
            if(result>arr[0][i])
            {
                result=arr[0][i];
            }
        }
        
        return result;
    }
}
