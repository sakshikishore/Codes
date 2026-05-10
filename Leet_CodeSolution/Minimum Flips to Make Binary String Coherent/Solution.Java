class Solution {
    public int minFlips(String s) {
        int zero=0,one=0;

        if(s.length()<3)
        {
            return 0;
        }
        for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)=='1')
                {
                    one++;
                }
                else
                {
                    zero++;
                }
            }
        if(one<2){
            return 0;
        }
        else if(one==2)
        {
            if(s.charAt(0)=='1' && s.charAt(s.length()-1)=='1')
            {
                return 0;
            }
            else
            {
                return 1;
            }
        }
        else
        {
            if(s.charAt(0)=='1' && s.charAt(s.length()-1)=='1')
            {
                return Math.min(zero,one-2);
            }
            else
            {
                return Math.min(zero, one-1);
            }
        }
        
        
    }
}
