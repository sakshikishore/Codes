class Solution {
    public long validSubstringCount(String word1, String word2) {
        int ch[]=new int[26];
        for(int i=0;i<word2.length();i++)
        {
            ch[word2.charAt(i)-'a']++;
        }
        long result=0;
        int ch1[]=new int[26];
        int start=0;
        for(int i=0;i<word1.length();i++)
        {
             ch1[word1.charAt(i)-'a']++;
             int flag=0;
             for(int j=0;j<ch.length;j++)
             {
                if(ch1[j]<ch[j])
                {
                    flag=1;
                    break;
                }
             }

             if(flag==0)
             {
                result+=word1.length()-i;
                start++;   
                while(start<=i)
                {
                     ch1[word1.charAt(start-1)-'a']--;
                    if(ch[word1.charAt(start-1)-'a']<=ch1[word1.charAt(start-1)-'a'])
                    {
                         result+=word1.length()-i;
                    }
                    else
                    {
                        break;
                    }  
                    start++;    
                }

             }
        }

        return result;
    }
}
