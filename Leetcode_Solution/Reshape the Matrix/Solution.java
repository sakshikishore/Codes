class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int arr[][]=new int[r][c];
        int p=nums.length*nums[0].length;
        
        if(r*c==p)
        {
          int l=0,m=0;
           for(int i=0;i<r;i++)
           {
               for(int j=0;j<c;j++)
               {
                   arr[i][j]=nums[l][m];
                   m++;
                   if(m==nums[0].length)
                   {
                       l++;
                       m=0;
                   }
               }
           }
            return arr;
        }
        else
        {
            return nums;
        }
        
    }
}
