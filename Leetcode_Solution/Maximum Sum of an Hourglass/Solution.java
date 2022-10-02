class Solution {
    public int maxSum(int[][] grid) {
        int maxSum=0;
        for(int i=0;i<=grid.length-3;i++)
        {
            for(int j=0;j<=grid[0].length-3;j++)
            {
                int sum=0;
                for(int r=i;r<3+i;r++)
                {
                    for(int c=j;c<j+3;c++)
                    {
                        if(r==i || r==(2+i))
                        {
                            sum+=grid[r][c];
                        }
                        else if((r==1+i) && c==j+1)
                        {
                            sum+=grid[r][c];
                        }
                    }
                }
                if(sum>maxSum)
                {
                    maxSum=sum;
                }
            }
        }
        
        return maxSum;
    }
}
