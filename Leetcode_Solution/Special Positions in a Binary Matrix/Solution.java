class Solution {
    public int numSpecial(int[][] mat) {
        int result=0;
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[i].length;j++)
            {
                if(mat[i][j]==1)
                {
                   int count=0;
                   for(int k=0;k<mat[i].length;k++)
                   {
                       if(mat[i][k]==1 && k!=j)
                       {
                           count++;
                           break;
                       }
                   }
                    
                  if(count==0)
                  {
                      for(int k=0;k<mat.length;k++)
                      {
                          if(mat[k][j]==1 && k!=i)
                          {
                              count++;
                              break;
                          }
                      }
                  }
                    if(count==0)
                    {
                        result++;
                    }
                }
            }
        }
        
        return result;
        
    }
}
