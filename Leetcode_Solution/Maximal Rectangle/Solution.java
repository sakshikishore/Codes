class Solution {
    public int maximalRectangle(char[][] matrix) {
        int arr[]=new int[matrix[0].length];
        int max=0;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(matrix[i][j]=='0')
                {
                    arr[j]=0;
                }
                else
                {
                    arr[j]+=1;
                }
            }
            for(int j=0;j<arr.length;j++)
            {
                int b=Integer.MAX_VALUE,l=0;
                for(int r=j;r<arr.length;r++)
                {
                    if(arr[r]==0)
                    {
                        break;
                    }
                    else
                    {
                        if(arr[r]<b)
                        {
                            b=arr[r];
                        }
                        l++;
                        if(l*b>max)
                        {
                            max=l*b;
                        }
                    }
                }
            }
        }
        
        return max;
    }
}
