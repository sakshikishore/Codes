class Solution {
    public long gridGame(int[][] grid) {
        long result=0;
        int n=grid[0].length;
        long suffix[]=new long[n];
        long prefix[]=new long[n];
        suffix[suffix.length-1]=grid[0][n-1];
        for(int i=suffix.length-2;i>=0;i--)
        {
            suffix[i]=grid[0][i]+suffix[i+1];
        }
        prefix[0]=grid[1][0];
        for(int i=1;i<prefix.length;i++)
        {
            prefix[i]=grid[1][i]+prefix[i-1];
        }
        for(int j=0;j<grid[0].length;j++)
        {
            if(j==0)
            {
                if(j+1<grid[0].length)
                {
                   result=suffix[j+1];
                   System.out.println(result);
                }
            }
                else if(j==grid[0].length-1)
                {
                    if(j-1>=0)
                    {
                        if(prefix[j-1]<result)
                        {
                            result=prefix[j-1];
                        }
                    }
                }
                else
                {
                    long p=Math.max(prefix[j-1],suffix[j+1]);
                    if(p<result)
                    {
                        result=p;
                    }
                }
        }

        return result;
    }
}
