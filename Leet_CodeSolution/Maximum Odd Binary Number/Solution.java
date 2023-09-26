class Solution {
    public String maximumOddBinaryNumber(String s) {
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
            {
                count++;
            }
        }
        char c[]=new char[s.length()];
        for(int i=0;i<s.length();i++)
        {
            c[i]='0';
        }
        c[c.length-1]='1';
        count--;
        for(int i=0;i<count;i++)
        {
            c[i]='1';
        }
        
        return new String(c);
    }
}
