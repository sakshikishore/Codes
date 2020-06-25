class Solution {
   
    public int numTrees(int n) {
     
        
        long j=2*n;
        long p=1;
        long k=n;
        for(int i=n;i>=1;i--)
        {
            
            if(i!=1)
            {
               if((p*j)%k==0)
               {
                   p=(p*j)/k;
                   k=i-1;
               }
                else
                {
                    p=p*j;
                    k=k*(i-1);
                }
            }
            j--;
        }

       return (int)p;
        
    }
}
