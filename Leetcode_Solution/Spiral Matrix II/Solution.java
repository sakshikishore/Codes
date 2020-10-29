class Solution {
    public int[][] generateMatrix(int n) {
        int j=1;
        int p=0;
        int arr[][]=new int[n][n];
        int count=0;
        while(j<=n*n)
        {
            if(p%4==0)
            {
                for(int i=count;i<n-count;i++)
                {
                    arr[count][i]=j;
                    j++;              
                }
                p++;
            }
            if(p%4==1)
            {
                for(int i=count+1;i<n-count;i++)
                {
                    arr[i][n-count-1]=j;
                    j++;
                }
                p++;
            }
            if(p%4==2)
            {
                for(int i=n-count-2;i>=count;i--)
                {
                    arr[n-count-1][i]=j;
                    j++;
                }
                p++;
            }
            if(p%4==3)
            {
                for(int i=n-count-2;i>=count+1;i--)
                {
                      arr[i][count]=j;
                    j++;
                }
                p++;
                
            }
            count++;
            
        }
         return arr;
    }
   
}
