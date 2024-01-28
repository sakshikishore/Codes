class Solution {
    public long flowerGame(int n, int m) {
        long ans=0;
        if(n%2==0)
        {
            long p=n/2;
           if(m%2!=0)
           {
               long q=(m/2)+1;
               ans=p*q;
                ans=ans+(p*(q-1));
                return ans;
           }
            else
            {
                long q=(m/2);
                ans=2*(p*q);
                return ans;
            }
        }
            
        else
        {
            long p=(n/2)+1;
             if(m%2!=0)
               {
                   long q=(m/2);
                   ans=p*q;
                    ans=ans+((p-1)*(q+1));
                    return ans;
               }
            else
            {
                long q=(m/2);
                ans=p*q;
                ans=ans+((p-1)*(q));
               return ans;
               
            }
            
            
        }
        

    }
}
