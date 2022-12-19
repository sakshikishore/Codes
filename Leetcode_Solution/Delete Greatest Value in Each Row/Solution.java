class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int arr[][]=new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            int a[]=new int[grid[0].length];
            for(int j=0;j<grid[0].length;j++)
            {
               a[j]=grid[i][j];
            }
            Arrays.sort(a);
            for(int j=0;j<grid[0].length;j++)
            {
               arr[i][j]=a[j];
            }
        }
        int sum=0;
        for(int i=0;i<grid[0].length;i++)
        {
            int max=0;
            for(int j=0;j<grid.length;j++)
            {
                if(arr[j][i]>max)
                {
                    max=arr[j][i];
                }
            }
            sum+=max;
        }

        return sum;
    }
}
