class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<Integer> l=new ArrayList<Integer>();
         ArrayList<Integer> t=new ArrayList<Integer>();
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j]==0)
                {
                    l.add(i);
                    t.add(j);
                }
            }
        }
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(l.contains(i))
                {
                    matrix[i][j]=0;
                }
                
                    if(t.contains(j))
                    {
                        matrix[i][j]=0;
                    }
                
            }
        }

        
        
    }
}
