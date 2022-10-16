class Solution {
    public int countTime(String time) {
        int result=0;
        if(time.charAt(0)=='?')
        {
            if(time.charAt(1)!='?')
            {
                if(time.charAt(1)>'3')
                {
                 result=2;
                }
                else
                {
                    result=3;
                }
            }
            else
               {
                   result=24;
               }
               
               if(time.charAt(3)=='?')
               {
                   if(time.charAt(4)=='?')
                   {
                       result=result*60;
                   }
                   else
                   {
                      result=result*6;
                   }
               }
               else if(time.charAt(4)=='?')
               {
                   result=result*10;
               }
            }
        else if(time.charAt(1)=='?')
        {
            if(time.charAt(0)=='2')
            {
                result=4;
            }
            else
            {
                result=10;
            }
            if(time.charAt(3)=='?')
               {
                   if(time.charAt(4)=='?')
                   {
                       result=result*60;
                   }
                   else
                   {
                      result=result*6;
                   }
               }
              else if(time.charAt(4)=='?')
              {
                  result=result*10;
              }
            
        }
        else if(time.charAt(3)=='?')
        {
                   if(time.charAt(4)=='?')
                   {
                       result=60;
                   }
                   else
                   {
                       result=6;
                   }
        }
        else if(time.charAt(4)=='?')
        {
            result=10;
        }
               if(result==0)
               {
                   return 1;
               }
     return result;
    }
}
