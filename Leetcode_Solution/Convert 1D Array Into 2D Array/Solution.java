class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int res[][];
        int p=0;
        if(m*n==original.length)
        {
            res=res=new int[m][n];
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    res[i][j]=original[p];
                    p++;
                }
            }
        }
        else
        {
            res=new int[0][0];
        }
        
        return res;
    }
}
