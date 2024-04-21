class Solution {
    public int numberOfSpecialChars(String word) {
        int count=0;
        int ch_lower[]=new int[26];
        int ch_upper[]=new int[26];
        for(int i=0;i<word.length();i++)
        {
            if(word.charAt(i)>='a' && word.charAt(i)<='z')
            {
            ch_lower[word.charAt(i)-'a']++;
            }
            else
            {
                ch_upper[word.charAt(i)-'A']++;
            }
            
        }
        for(int i=0;i<26;i++)
        {
            if(ch_upper[i]>=1 && ch_lower[i]>=1)
            {
                count++;
            }
        }
        
        return count;
    }
}
