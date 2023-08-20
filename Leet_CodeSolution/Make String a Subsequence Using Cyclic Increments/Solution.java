class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        if(str1.length()<str2.length())
        {
            return false;
        }
        int i=0,j=0;
        while(j<str2.length() && i<str1.length())
        {
            if(str1.charAt(i)==str2.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                int x=((str1.charAt(i)-'a')+1)%26;
                char c=(char)(97+x);
                if(c==str2.charAt(j))
                {
                    i++;
                    j++;
                }
                else
                {
                    i++;
                }
            }
        }
        if(j==str2.length())
        {
            return true;
        }
        
        return false;
    }
}
