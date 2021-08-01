class Solution {
    public boolean canConstruct(String s, int k) {
        boolean result=true;
        if(s.length()<k)
        {
            result=false;
        }
        else
        {
            int ch[]=new int [26];
            int count=0;
            for(int i=0;i<s.length();i++)
            {
                ch[s.charAt(i)-'a']++;
            }
            for(int i=0;i<26;i++)
            {
                if(ch[i]%2!=0)
                {
                    count++;
                }
            }

            if(count>k)
            {
                result=false;
            }
        }
        
        return result;
    }
}
