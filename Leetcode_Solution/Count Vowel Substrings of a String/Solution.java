class Solution {
    public int countVowelSubstrings(String word) {
        int count=0;
        for(int i=0;i<word.length();i++)
        {
             int ch[]=new int[26];
            if(word.charAt(i)=='a' || word.charAt(i)=='e' || word.charAt(i)=='i' || word.charAt(i)=='o' || word.charAt(i)=='u')
            {
                ch[word.charAt(i)-'a']++;
                for(int j=i+1;j<word.length();j++)
                {
                    if(word.charAt(j)=='a' || word.charAt(j)=='e' || word.charAt(j)=='i' || word.charAt(j)=='o' || word.charAt(j)=='u')
                    {
                      ch[word.charAt(j)-'a']++;
                       if(ch[0]>0 && ch[4]>0 && ch[8]>0 && ch[14]>0 && ch[20]>0)
                       {
                           count++;
                       }
                    }
                    else
                    {
                        break;
                    }
                }
            }
        }
        
        return count;
        
    }
}
