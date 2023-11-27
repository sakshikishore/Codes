class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int arr[][]=new int[mat.length][mat[0].length];
        for(int i=0;i<mat.length;i++)
        {
            if(i%2!=0)
            {
                for(int j=0;j<mat[0].length;j++)
                {
                    arr[i][(j+k)%mat[0].length]=mat[i][j];
                }
            }
            else
            {
                for(int j=0;j<mat[0].length;j++)
                {
                    int p=(j-k)%mat[0].length;
                    if(p<0)
                    {
                        p=p+mat[0].length;
                    }

                    arr[i][p]=mat[i][j];
                }
            }
        }
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]!=arr[i][j])
                {
                    return false;
                }
            }
        }


        return true;
    }
}
