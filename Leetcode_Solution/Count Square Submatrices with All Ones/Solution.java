class Solution {
    public int countSquares(int[][] matrix) {
        int count=0;
        for(int i=0;i<matrix[0].length;i++)
        {
            int arr[]=new int[matrix.length];
            for(int j=i;j<matrix[0].length;j++)
            {
                for(int k=0;k<matrix.length;k++)
                {
                        arr[k]+=matrix[k][j];
                }
                int x=j-i;
                for(int k=0;k<matrix.length-x;k++)
                {
                    int r=k+x;
                    int flag=0;
                    for(int p=k;p<=r;p++)
                    {
                        if(arr[p]!=x+1)
                        {
                            flag=1;
                            break;
                        }
                    }
                    if(flag==0)
                    {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}
