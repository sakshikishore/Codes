class Solution {
    public int longestPalindrome(String s) {
        int ch[]=new int[52];
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)>='a' && s.charAt(i)<='z')
            {
            ch[s.charAt(i)-'a']++;
            }
            else
            {
                ch[26+s.charAt(i)-'A']++;
            }
        }
        int total=0;
        int r=0;
        for(int i=0;i<52;i++)
        {
            if(ch[i]!=0)
            {
                if(ch[i]%2==0)
                {
                    total=total+ch[i];
                }
                else
                {
                    if(r==0)
                    {
                        total=total+ch[i];
                        r++;
                    }
                    else
                    {
                        total=total+ch[i]-1;
                    }
                }
            }
        }
        
        return total;
        
    }
}
