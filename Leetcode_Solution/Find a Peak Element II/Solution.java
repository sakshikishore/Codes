class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int count=4;
        int result[]=new int[2];
        int flag=0;
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[i].length;j++)
            {
                if(j-1>=0)
                {
                    if(mat[i][j]<=mat[i][j-1])
                    {
                        count--;
                    }
                }
                if(j+1<mat[i].length)
                {
                    if(mat[i][j+1]>=mat[i][j])
                    {
                        count--;
                    }
                }
                if(i-1>=0)
                {
                    if(mat[i-1][j]>=mat[i][j])
                    {
                        count--;
                    }
                }
                if(i+1<mat.length)
                {
                    if(mat[i+1][j]>=mat[i][j])
                    {
                        count--;
                    }
                }
                if(count==4)
                {
                    result[0]=i;
                    result[1]=j;
                    flag=1;
                    break;
                }
            else
            {
                count=4;
            }
        }
            if(flag==1)
            {
                break;
            }
            
        }
        
        return result;
        
    }
}
