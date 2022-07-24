class Solution {
    public char repeatedCharacter(String s) {
        int ch[]=new int[26];
        char result='a';
        for(int i=0;i<s.length();i++)
        {
            ch[s.charAt(i)-'a']++;
            if(ch[s.charAt(i)-'a']==2)
            {
                result=s.charAt(i);
                break;
            }
        }
        
        return result;
    }
}
