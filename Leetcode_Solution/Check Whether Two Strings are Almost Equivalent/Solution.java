class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        int ch1[]=new int[26];
        int ch2[]=new int[26];
        boolean result=true;
        for(int i=0;i<word1.length();i++)
        {
            ch1[word1.charAt(i)-'a']++;
        }
        for(int i=0;i<word2.length();i++)
        {
            ch2[word2.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++)
        {
            int p=Math.abs(ch1[i]-ch2[i]);
            if(p>3)
            {
                result=false;
                break;
            }
        }
        
        return result;
        
    }
}
