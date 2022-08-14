class Solution {
    public String breakPalindrome(String palindrome) {
        String res="";
        if(palindrome.length()==1)
        {
            return res;
        }
        if(palindrome.length()%2==0)
        {
            for(int i=0;i<palindrome.length();i++)
            {
                char c[]=palindrome.toCharArray();
                if(c[i]=='a')
                {
                    c[i]='b';
                }
                else
                {
                    c[i]='a';
                }
                String str=new String(c);
                if(i==0)
                {
                    res=str;
                }
                else
                {
                    if(str.compareTo(res)<0)
                    {
                        res=str;
                    }
                }
            }
        }
        else
        {
            for(int i=0;i<palindrome.length();i++)
            {
                if(i!=palindrome.length()/2)
                {
                        char c[]=palindrome.toCharArray();
                        if(c[i]=='a')
                        {
                            c[i]='b';
                        }
                        else
                        {
                            c[i]='a';
                        }
                        String str=new String(c);
                        if(i==0)
                        {
                            res=str;
                        }
                        else
                        {
                            if(str.compareTo(res)<0)
                            {
                                res=str;
                            }
                        }
                }
            }
        }
        
        return res;
    }
}
