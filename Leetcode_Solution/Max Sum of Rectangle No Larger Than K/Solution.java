class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<matrix[0].length;i++)
        {
            int arr[]=new int[matrix.length];
            for(int j=i;j<matrix[0].length;j++)
            {
                for(int k1=0;k1<matrix.length;k1++)
                {
                    arr[k1]+=matrix[k1][j];
                }
                for(int k1=0;k1<matrix.length;k1++)
                {
                    int sum=0;
                    for(int l=k1;l<matrix.length;l++)
                    {
                        sum=sum+arr[l];
                        if(sum<=k && sum>max)
                        {
                            max=sum;
                        }
                    }
                }
            }
        }
        
        return max;
    }
}
