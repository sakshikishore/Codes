class Solution {
    public boolean areOccurrencesEqual(String s) {
        int ch[]=new int[26];
        boolean result=true;
        for(int i=0;i<s.length();i++)
        {
            ch[s.charAt(i)-'a']++;
        }
        int p=ch[s.charAt(0)-'a'];
        for(int i=0;i<26;i++)
        {
            if(ch[i]!=0)
            {
                if(ch[i]!=p)
                {
                    result=false;
                    break;
                }
            }
        }
        
        return result;
    }
}
