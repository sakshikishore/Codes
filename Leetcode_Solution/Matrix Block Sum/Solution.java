class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int result[][]=new int[mat.length][mat[0].length];
      for(int i=0;i<mat.length;i++)
      {
          for(int j=0;j<mat[i].length;j++)
          {
              int p=i-K;
              int q=i+K;
              int l=j-K;
              int m=j+K;
              
              if(p<0)
              {
                  p=0;
              }
              if(q>mat.length-1)
              {
                  q=mat.length-1;
              }
              if(l<0)
              {
                  l=0;
              }
              if(m>mat[i].length-1)
              {
                  m=mat[i].length-1;
              }
              
              for(int r=p;r<=q;r++)
              {
                  for(int c=l;c<=m;c++)
                  {
                      result[i][j]+=mat[r][c];
                  }
              }
          }
      }
        return result;
        
    }
}
