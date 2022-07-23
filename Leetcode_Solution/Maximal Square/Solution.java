class Solution {
    public int maximalSquare(char[][] matrix) {
        int max=0;
       for(int i=0;i<matrix[0].length;i++)
       {
           int arr[]=new int[matrix.length];
           for(int j=i;j<matrix[0].length;j++)
           {
               for(int k=0;k<arr.length;k++)
               {
                  if(matrix[k][j]=='1')
                  {
                      arr[k]+=1;
                  }
               }
               int r=j-i;
               if(max<((r+1)*(r+1)))
               {
                   for(int k=0;k<matrix.length-r;k++)
                   {
                        int flag=0;
                       for(int p=k;p<=r+k;p++)
                       {
                           if(arr[p]!=(r+1))
                           {
                               flag=1;
                               break;
                           }
                       }
                       if(flag==0)
                       {
                           max=(r+1)*(r+1);
                           break;
                       }
                   }
               }
           }
       }
        
        return max;
    }
}
