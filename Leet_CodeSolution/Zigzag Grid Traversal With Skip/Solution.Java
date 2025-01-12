class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> result=new ArrayList<Integer>();
        int j=0;
        for(int i=0;i<grid.length;i=i+2)
        {
           while(j<grid[0].length)
           {
             result.add(grid[i][j]);
             j=j+2;
           }
           if(j-2==grid[0].length-1)
           {
            j=j-3;
           }
           else
           {
            j=grid[0].length-1;
           }
            if(i+1<grid.length)
            {
                while(j>=0)
                {
                    result.add(grid[i+1][j]);
                    j=j-2;
                }
                if(j==-1)
                {
                      j=0;
                }
                else
                {
                    j=1;
                }
            }
        }

        return result;
    }
}
