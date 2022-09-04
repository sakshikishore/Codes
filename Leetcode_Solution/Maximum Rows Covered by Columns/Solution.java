class Solution {
    public int maximumRows(int[][] mat, int cols) {
        int n=mat[0].length;
        int max=0;
        if(n==cols)
        {
            return mat.length;
        }
        int count=0;
        for(int i=0;i<mat[0].length;i++)
        {
            for(int j=0;j<mat.length;j++)
            {
                if(mat[j][i]==1)
                {
                    count++;
                    break;
                }
            }
        }
        if(count<=cols)
        {
            return mat.length;
        }
        for(int i=0;i<(1<<n);i++)
        {
            ArrayList<Integer> l=new ArrayList<Integer>();
            for(int j=0;j<n;j++)
            {
                  if((i & (1<<j))>0)
                   {
                       l.add(j);
                   }
            }
                    if(l.size()==cols)
                     {
                         int arr[][]=new int[mat.length][n];
                         for(int x=0;x<arr.length;x++)
                         {
                             for(int y=0;y<arr[0].length;y++)
                             {
                                 arr[x][y]=mat[x][y];
                             }
                         }
                         for(int k=0;k<l.size();k++)
                         {
                             for(int p=0;p<arr.length;p++)
                             {
                                 arr[p][l.get(k)]=0;
                             }
                         }
                         count=0;
                         for(int x=0;x<arr.length;x++)
                         {
                             int flag=0;
                             for(int y=0;y<arr[0].length;y++)
                             {
                                if(arr[x][y]==1)
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
                         
                         if(count>max)
                         {
                             max=count;
                         }
                         
                     }
        }
                     
                     return max;
        
        
    }
}
