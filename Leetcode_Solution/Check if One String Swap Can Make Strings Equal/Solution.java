class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        boolean result=true;
        int count=0;
        int ch[]=new int[26];
        for(int i=0;i<s1.length();i++)
        {
            ch[s1.charAt(i)-'a']++;
            ch[s2.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++)
        {
            if(ch[i]!=0)
            {
                result=false;
                break;
            }
        }
        if(result)
        {
            for(int i=0;i<s1.length();i++)
            {
                if(s1.charAt(i)!=s2.charAt(i))
                {
                    count++;
                    if(count==3)
                    {
                        result=false;
                        break;
                    }
                }
            }
        }
        return result;
        
    }
}
