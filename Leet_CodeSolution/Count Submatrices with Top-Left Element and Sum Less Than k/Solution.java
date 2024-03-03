class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int count=0;
        for(int i=1;i<grid[0].length;i++)
        {
            for(int j=0;j<grid.length;j++)
            {
                grid[j][i]=grid[j][i]+grid[j][i-1];
            }
        }
        for(int i=0;i<grid[0].length;i++)
        {
            int ans=0;
            for(int j=0;j<grid.length;j++)
            {
                 ans+=grid[j][i];
                 if(ans<=k)
                 {
                     count++;
                 }
                else
                {
                    break;
                }
            }
        }
        
        return count;
    }
}
