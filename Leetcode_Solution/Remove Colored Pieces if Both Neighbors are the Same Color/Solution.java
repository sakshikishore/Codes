class Solution {
    public boolean winnerOfGame(String colors) {
       int a=0,b=0;
       int count1=0,count2=0;
        for(int i=0;i<colors.length();i++)
        {
            if(colors.charAt(i)=='A')
            {
                count1++;
                if(count2>2)
                {
                    b=b+count2-2;
                }
                count2=0;
                
            }
            else
            {
                if(count1>2)
                {
                    a=a+count1-2;
                }
                count1=0;
                count2++;
            }
        }
        
        if(count1>2)
        {
            a=a+count1-2;
        }
         if(count2>2)
         {
            b=b+count2-2;
         }
        if(a>b)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
