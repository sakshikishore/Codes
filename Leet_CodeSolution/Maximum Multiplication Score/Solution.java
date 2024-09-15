class Solution {
    
    public long maxScore(int[] a, int[] b) {
       long ans=Long.MIN_VALUE;
       long res[][]=new long[4][b.length];
       for(int i=0;i<a.length;i++)
       {
        for(int j=i;j<b.length;j++)
        {
            if(i==0)
            {
                if(j==i)
                {
                   res[i][j]=1l*a[i];
                   res[i][j]=res[i][j]*b[j];
                }
                else
                {
                     long p=a[i]*1l;
                     res[i][j]=Math.max(res[i][j-1],(p*b[j]));
                }
            }
            else
            {
                if(j==i)
                {
                   res[i][j]=1l*a[i];
                   res[i][j]=res[i-1][j-1]+(res[i][j]*b[j]);
                }
                else
                {
                    long p=a[i]*1l;
                    p=p*b[j];
                    res[i][j]=Math.max(res[i-1][j-1]+p,res[i][j-1]);
                    
                }
            }
        }
       }

       return res[3][b.length-1];
    }
}
