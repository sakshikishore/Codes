class Solution {
    public boolean checkZeroOnes(String s) {
        int ones=0;
        int zeroes=0;
        int a=0,b=0;
        boolean result=false;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
            {
                a++;
                if(b>zeroes)
                {
                   zeroes=b; 
                }
                b=0;
            }
            else
            {
                b++;
                if(a>ones)
                {
                    ones=a;
                }
                a=0;
            }
            
        }
        if(a>ones)
        {
          ones=a;
        }
        if(b>zeroes)
        {
          zeroes=b; 
        }
        
        if(ones>zeroes)
        {
            result=true;
        }
        
        return result;
    }
}
