import java.math.BigInteger;
class Solution {
    public int numSteps(String s) {
        int carry=0;
        int result=0;
       for(int i=s.length()-1;i>=1;i--)
       {
           if(s.charAt(i)=='0')
           {
               if(carry==1)
               {
                   result=result+2;
               }
               else
               {
                   result++;
               }
              
           }
           else
           {
               
               if(carry==1)
               {
                   result++;
               }
               else
               {
                   result=result+2;
                   carry=1;
               }
               
           }
       }
        
        if(s.charAt(0)=='1')
        {
            if(carry==1)
            {
                result++;
            }
        }
        
        return result;
    }
}
