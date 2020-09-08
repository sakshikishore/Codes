class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        boolean result=true;
        if(bits[bits.length-1]==1)
        {
            result=false;
        }
        else
        {
           if(bits.length>1 && bits[bits.length-2]==1)
           {
               int i=0;
               while(i<bits.length)
               {
                   if(bits[i]==1)
                   {
                       i=i+2;
                       if(i==bits.length)
                       {
                           result=false;
                       }
                   }
                   else
                   {
                       i++;
                   }
               }
           }
        }
        
        return result;
        
    }
}
