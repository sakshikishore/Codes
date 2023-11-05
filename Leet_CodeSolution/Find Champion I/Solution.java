class Solution {
    public int findChampion(int[][] grid) {
        int arr[]=new int[grid.length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(i!=j)
                {
                    if(grid[i][j]==1)
                    {
                        arr[i]++;
                    }
                }
            }
        }
        int max=0,result=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>max)
            {
                max=arr[i];
                result=i;
            }
        }
        
        return result;
    }
}
