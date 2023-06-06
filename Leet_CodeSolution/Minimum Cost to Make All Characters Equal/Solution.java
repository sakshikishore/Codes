class Solution {
    public long minimumCost(String s) {
        char left='0';
        long result=0;
        if(s.charAt(0)=='1')
        {
               left='1';
        }
        int flag=0;
        for(int i=1;i<s.length();i++)
        {
            char p=s.charAt(i);
            if(flag==1)
            {
                if(p=='1')
                {
                    p='0';
                }
                else
                {
                    p='1';
                }
            }
            if(p!=left)
            {
                if(i<=s.length()-i)
                {
                    if(left=='1')
                    {
                        left='0';
                    }
                    else
                    {
                        left='1';
                    }
                    result+=i;
                }
                else
                {
                   flag=flag^1;
                   result+=s.length()-i;
                }
            }
        }

        return result;
    }
}
