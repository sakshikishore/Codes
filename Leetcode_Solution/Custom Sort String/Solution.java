class Solution {
    public String customSortString(String order, String s) {
        int ch[]=new int[26];
        char c[]=new char[s.length()];
        for(int i=0;i<s.length();i++)
        {
            ch[s.charAt(i)-'a']++;
        }
        int p=0;
        for(int i=0;i<order.length();i++)
        {
            if(ch[order.charAt(i)-'a']>0)
            {
                int k=ch[order.charAt(i)-'a'];
                for(int j=0;j<k;j++)
                {
                    c[p]=order.charAt(i);
                    ch[order.charAt(i)-'a']--;
                    p++;
                }
            }
        }
        for(int i=0;i<s.length();i++)
        {
            if(ch[s.charAt(i)-'a']>0)
            {
                int k=ch[s.charAt(i)-'a'];
                for(int j=0;j<k;j++)
                {
                    c[p]=s.charAt(i);
                     ch[s.charAt(i)-'a']--;
                    p++;
                }
                
            }
           
        }
        
        return new String(c);
    }
}
