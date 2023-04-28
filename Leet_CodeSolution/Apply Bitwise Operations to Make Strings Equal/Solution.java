class Solution {
    public boolean makeStringsEqual(String s, String target) {
      // 0, 0 => 0, 0 - 1st Case
      // 1, 0 => 1, 1 - 2nd Case
      // 1, 1=> 1, 0  - 3rd Case

       int ones=0,zeroes=0;
       int tempOnes=0,tempZeroes=0;
       boolean result=true;
       for(int i=0;i<s.length();i++)
       {
           if(s.charAt(i)=='0')
           {
               zeroes++;
           }
           else
           {
               ones++;
           }
       }
       tempZeroes=zeroes;
       tempOnes=ones;
       for(int i=0;i<s.length();i++)
       {
           if(s.charAt(i)!=target.charAt(i))
           {
               if(s.charAt(i)=='1')
               {
                   // 3rd Case
                   if(ones>1)
                   {
                       ones--;
                       zeroes++;
                   }
                   else
                   {
                       result=false;
                       break;
                   }
               }
               else
               {
                   // 2nd Case
                   if(ones>0)
                   {
                       ones++;
                       zeroes--;
                   }
                   else
                   {
                       result=false;
                       break;
                   }

               }
           }
       }
      if(!result)
      {
          result=true;
          ones=tempOnes;
          zeroes=tempZeroes;
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)!=target.charAt(i))
            {
                if(s.charAt(i)=='1')
                {
                    // 3rd Case
                    if(ones>1)
                    {
                        ones--;
                        zeroes++;
                    }
                    else
                    {
                        result=false;
                        break;
                    }
                }
                else
                {
                    // 2nd Case
                    if(ones>0)
                    {
                        ones++;
                        zeroes--;
                    }
                    else
                    {
                        result=false;
                        break;
                    }

                }
            }
        }
      }
       return result;
    }
}
