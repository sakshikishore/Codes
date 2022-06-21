class Solution {
    public String greatestLetter(String s) {
        int ch1[]=new int[26];
        int ch2[]=new int[26];
        String ans="";
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)>='a' && s.charAt(i)<='z')
            {
              ch1[s.charAt(i)-'a']++;
            }
            else
            {
                ch2[s.charAt(i)-'A']++;
            }
        }
        
        for(int i=0;i<26;i++)
        {
            if(ch1[i]>0 && ch2[i]>0)
            {
                ans=Character.toString((char)(65+i));
            }
        }
        
        return ans;
        
    }
}
