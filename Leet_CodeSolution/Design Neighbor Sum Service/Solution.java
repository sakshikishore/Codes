class neighborSum {
    int mat[][];
    public neighborSum(int[][] grid) {
        mat=grid;
    }
    
    public int adjacentSum(int value) {
        int sum=0;
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==value)
                {
                    if(i-1>=0)
                    {
                        sum+=mat[i-1][j];
                    }
                    if(i+1<mat.length)
                    {
                        sum+=mat[i+1][j];
                    }
                    if(j-1>=0)
                    {
                       sum+=mat[i][j-1];
                    }
                    if(j+1<mat[0].length)
                    {
                        sum+=mat[i][j+1];
                    }
                    break;
                }
            }
        }

        return sum;
    }
    
    public int diagonalSum(int value) {
        int sum=0;
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                if(mat[i][j]==value)
                {
                    if(i-1>=0 && j-1>=0)
                    {
                        sum+=mat[i-1][j-1];
                    }
                    if(i+1<mat.length && j+1<mat[0].length)
                    {
                        sum+=mat[i+1][j+1];
                    }
                    if(j-1>=0 && i+1<mat.length)
                    {
                       sum+=mat[i+1][j-1];
                    }
                    if(j+1<mat[0].length && i-1>=0)
                    {
                        sum+=mat[i-1][j+1];
                    }
                    break;
                }
            }
        }

        return sum;
    }
}
