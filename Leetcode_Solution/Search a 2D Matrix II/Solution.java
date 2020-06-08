class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean result=false;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(target<matrix[i][j])
                {
                    break;
                }
                if(target==matrix[i][j])
                {
                    result=true;
                    break;
                }
                
            }
        }
        
        return result;
    }
}
