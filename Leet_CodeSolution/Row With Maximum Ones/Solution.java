class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int result[]=new int[2];
        for(int i=0;i<mat.length;i++)
        {
            int count=0;
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==1)
                {
                    count++;
                }
            }
            if(count>result[1])
            {
                result[1]=count;
                result[0]=i;
            }
        }
        
        return result;
    }
}
