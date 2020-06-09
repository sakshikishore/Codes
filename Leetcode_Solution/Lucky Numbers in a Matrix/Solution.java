class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<matrix[0].length;i++)
        {
            int max=matrix[0][i];
            for(int j=1;j<matrix.length;j++)
            {
                if(matrix[j][i]>max)
                {
                    max=matrix[j][i];
                }
            }
            l.add(max);
        }
        ArrayList<Integer> result=new ArrayList<Integer>();
        for(int i=0;i<matrix.length;i++)
        {
            int min=matrix[i][0];
            int minIndex=0;
            for(int j=1;j<matrix[0].length;j++)
            {
                if(matrix[i][j]<min)
                {
                    min=matrix[i][j];
                    minIndex=j;
                }
            }
            if(l.get(minIndex)==min)
            {
                result.add(min);
            }
        }
        
        return result;
    }
}
