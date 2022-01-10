class Solution {
    public boolean checkValid(int[][] matrix) {
        boolean result=true;
        for(int i=0;i<matrix.length;i++)
        {
            int a[]=new int[matrix.length];
            for(int j=0;j<matrix[i].length;j++)
            {
                a[matrix[i][j]-1]++;
            }
            for(int j=0;j<matrix.length;j++)
            {
                if(a[j]==0)
                {
                    result=false;
                    break;
                }
            }
        }
        
        if(result)
        {
            for(int i=0;i<matrix[0].length;i++)
            {
                 int a[]=new int[matrix.length];
                for(int j=0;j<matrix.length;j++)
                {
                    a[matrix[j][i]-1]++;
                }
                for(int j=0;j<matrix.length;j++)
                {
                    if(a[j]==0)
                    {
                        result=false;
                        break;
                    }
                }
            }
        }
        
        return result;
    }
}
