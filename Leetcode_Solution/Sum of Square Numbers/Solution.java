class Solution {
    public boolean judgeSquareSum(int c) {
       boolean result=false;
        int a=(int)Math.sqrt(c);
        int x=c-(a*a);
       
           int b=(int)Math.sqrt(x);
           if(b*b==x)
           {
               result=true;
           }
          else
          {
              while(a!=0)
              {
                  a--;
                    x=c-(a*a);
                    b=(int)Math.sqrt(x);
                   if(b*b==x)
                   {
                       result=true;
                       break;
                   }

              }
          }
            
        
        
        return result;
    }
}
