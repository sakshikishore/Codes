class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int maxVal[]=new int[matrix[0].length];
        for(int i=0;i<matrix[0].length;i++)
        {
            int max=-2;
            for(int j=0;j<matrix.length;j++)
            {
                if(matrix[j][i]>max)
                {
                    max=matrix[j][i];
                }
            }
            maxVal[i]=max;
        }
        
        for(int i=0;i<matrix[0].length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                if(matrix[j][i]==-1)
                {
                    matrix[j][i]=maxVal[i];
                }
            }
        }
        
        return matrix;
    }
}
