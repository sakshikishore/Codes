class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int count=0;
        for(int i=0;i<matrix[0].length;i++)
        {
            int arr[]=new int[matrix.length];
            for(int j=i;j<matrix[0].length;j++)
            {
               for(int p=0;p<matrix.length;p++)
               {
                   arr[p]+=matrix[p][j];
               }
                for(int l=0;l<arr.length;l++)
                {
                    int sum=0;
                    for(int m=l;m<arr.length;m++)
                    {
                        sum=sum+arr[m];
                        if(sum==target)
                        {
                            count++;
                        }
                    }
                }
            }
        }
        
        return count;
        
    }
}
