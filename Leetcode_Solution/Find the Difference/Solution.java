class Solution {
    public char findTheDifference(String s, String t) {
        int ch[]=new int[26];
        char result='a';
        for(int i=0;i<s.length();i++)
        {
            ch[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length();i++)
        {
            ch[t.charAt(i)-'a']--;
            if(ch[t.charAt(i)-'a']==-1)
            {
                result=t.charAt(i);
                break;
            }
        }
        
        return result;
    }
}
