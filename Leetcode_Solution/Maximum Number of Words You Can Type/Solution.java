class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String str[]=text.split(" ");
        int ch[]=new int[26];
        int result=0;
        for(int i=0;i<brokenLetters.length();i++)
        {
            ch[brokenLetters.charAt(i)-'a']++;
        }
        for(int i=0;i<str.length;i++)
        {
            int count=0;
            for(int j=0;j<str[i].length();j++)
            {
                if(ch[str[i].charAt(j)-'a']>0)
                {
                    count++;
                    break;
                }
            }
            if(count==0)
            {
                result++;
            }
        }
        
        return result;
    }
}
