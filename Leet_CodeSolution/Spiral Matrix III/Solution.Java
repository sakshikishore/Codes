class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int result[][]=new int[rows*cols][2];
        result[0][0]=rStart;
        result[0][1]=cStart;
        int i=1;
        int count=1;
        while(i<result.length)
        {
            if(rStart>=0)
            {
                for(int j=cStart+1;j<=count+cStart && j<cols;j++)
                {
                    if(j>=0)
                    {
                        result[i][0]=rStart;
                        result[i][1]=j;
                        i++;
                        if(i==result.length)
                        {
                            break;
                        }
                    }
                }
            }
           cStart=count+cStart;
           if(cStart<cols)
           {
             for(int j=rStart+1;j<=rStart+count && j<rows;j++)
             {
                    if(j>=0)
                    {
                        result[i][0]=j;
                        result[i][1]=cStart;
                        i++;
                        if(i==result.length)
                        {
                            break;
                        }
                    }
             }    
           }
           rStart=rStart+count;
            if(i==result.length)
                    {
                        break;
                    }
           count=count+1;
           if(rStart<rows)
           {
            int p=0;
            for(int j=cStart-1;j>=0;j--)
            {
                   if(j<cols)
                   {
                        result[i][0]=rStart;
                        result[i][1]=j;
                        i++;
                        if(i==result.length)
                        {
                            break;
                        }
                   }
                        p++;
                if(p==count)
                {
                    break;
                }
            }
           }
           cStart=cStart-count;
           if(cStart>=0)
           {
          int p=0;
           for(int j=rStart-1;j>=0;j--)
           {
                    if(j<rows)
                    {
                    result[i][0]=j;
                    result[i][1]=cStart;
                    i++;
                     if(i==result.length)
                    {
                        break;
                    }
                    }
                    p++;
              if(p==count)
              {
                break;
              }
           }
           }
           rStart=rStart-count;
           count=count+1;
        }
        return result;

    }
}
