class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int max=0;
        int total=0;
        if(ops.length==0)
        {
            total=m*n;
        }
        else if(ops.length==1)
        {
            total=ops[0][0]*ops[0][1];
        }
        else
        {
            int x=ops[0][0];
            int y=ops[0][1];
           for(int i=1;i<ops.length;i++)
           {
               if(ops[i][0]<x)
               {
                   x=ops[i][0];
               }
               if(ops[i][1]<y)
               {
                   y=ops[i][1];
               }
           }
            total=x*y;
        }
        
        return total;
        
        
    }
}
