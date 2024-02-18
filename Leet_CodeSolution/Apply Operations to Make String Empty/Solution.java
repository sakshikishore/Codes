class Solution {
    public String lastNonEmptyString(String s) {
        int ch[]=new int[26];
        int max=0;
        for(int i=0;i<s.length();i++)
        {
            ch[s.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++)
        {
            if(ch[i]>max)
            {
                max=ch[i];
            }
        }
        String res="";
        for(int i=s.length()-1;i>=0;i--)
        {
            if(ch[s.charAt(i)-'a']==max)
            {
                res=s.charAt(i)+res;
                ch[s.charAt(i)-'a']--;
            }
        }
        
        return res;
    }
}
