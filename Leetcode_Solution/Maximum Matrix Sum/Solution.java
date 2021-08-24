class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int count=0;
        int min=1000000;
        long sum=0;
        int l=0;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                sum=sum+Math.abs(matrix[i][j]);
                int p=Math.abs(matrix[i][j]);
                    if(p<min)
                    {
                        min=p;
                    }
                if(matrix[i][j]<0)
                {
                    count++;
                    
                    if((i+1)<matrix.length)
                    {
                        if(matrix[i+1][j]==0)
                        {
                            l++;
                        }
                    }
                     if(j+1<matrix[i].length)
                        {
                            if(matrix[i][j+1]==0)
                            {
                                l++;
                            }
                        }
                   if(j-1>=0)
                    {
                        if(matrix[i][j-1]==0)
                            {
                                l++;
                            }
                    }
                    if(i-1>=0)
                    {
                        if(matrix[i-1][j]==0)
                            {
                                l++;
                            }
                    }
                }
            }
        }
        if(count%2!=0)
        {
            if(l==0)
            {              
              sum=sum-(2*min);
            }
        }
        
        return sum;
        
    }
}
