class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int arr[][]=new int[matrix.length][matrix[0].length];
        for(int i=matrix.length-1;i>=0;i--)
        {
            for(int j=matrix[i].length-1;j>=0;j--)
            {
                if(i==matrix.length-1)
                {
                    arr[i][j]=matrix[i][j];
                }
                else
                {
                    if(j==matrix[i].length-1)
                    {
                    arr[i][j]=matrix[i][j]+Math.min(arr[i+1][j],arr[i+1][j-1]);
                    }
                    else if(j==0)
                    {
                     arr[i][j]=matrix[i][j]+Math.min(arr[i+1][j],arr[i+1][j+1]);
                    }
                    else
                    {
                         int p=Math.min(arr[i+1][j],arr[i+1][j+1]);
                         arr[i][j]=matrix[i][j]+Math.min(p,arr[i+1][j-1]);
        
                    }
                }
            }
        }
        int min=arr[0][0];
        
    for(int i=1;i<arr[0].length;i++)
    {
        if(arr[0][i]<min)
        {
            min=arr[0][i];
        }
    }
        
        return min;
        
    }
}
