class Solution {
    public int[] findColumnWidth(int[][] grid) {
        int result[]=new int[grid[0].length];
        for(int i=0;i<grid[0].length;i++)
        {
            int max=0;
            for(int j=0;j<grid.length;j++)
            {
                String str=Integer.toString(grid[j][i]);
                if(str.length()>max)
                {
                    max=str.length();
                }
            }
            
            result[i]=max;
        }
        
        return result;
    }
}
