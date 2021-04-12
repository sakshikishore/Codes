class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int arr1[]=new int[grid.length];
        int arr2[]=new int[grid[0].length];
        int sum1=0,sum2=0;
        for(int i=0;i<grid.length;i++)
        {
            int max=0;
           
            for(int j=0;j<grid[i].length;j++)
            {
              sum1=sum1+grid[i][j];
               if(max<grid[i][j])
               {
                   max=grid[i][j];
               }
            }
            arr1[i]=max;
        }
        
        for(int i=0;i<grid[0].length;i++)
        {
            int max=0;
            for(int j=0;j<grid.length;j++)
            {
               if(max<grid[j][i])
               {
                   max=grid[j][i];
               }
            }
            arr2[i]=max;
        }
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
              if(arr1[i]>arr2[j])
              {
                  grid[i][j]=arr2[j];
              }
              else
              {
                 grid[i][j]=arr1[i];
              }
                sum2=sum2+grid[i][j];
            }
            
           
        }
        
        return sum2-sum1;
    }
}
