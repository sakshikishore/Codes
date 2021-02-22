class Solution {
    public String longestNiceSubstring(String s) {
        String res="";
        for(int i=0;i<s.length();i++)
        {
            String str=s.substring(i,i+1);
            for(int j=i+1;j<s.length();j++)
            {
              str=str+s.substring(j,j+1);
                if(str.length()>res.length())
                {
                  int count=0;
                  int ch1[]=new int [26];
                  int ch2[]=new int [26];
                for(int t=0;t<str.length();t++)
                {
                    if(str.charAt(t)>='A' && str.charAt(t)<='Z')
                    {
                        ch1[str.charAt(t)-'A']++;
                    }
                    
                }
                for(int t=0;t<str.length();t++)
                {
                    if(str.charAt(t)>='a' && str.charAt(t)<='z')
                    {
                        ch2[str.charAt(t)-'a']++;
                    }
                }
                    for(int t=0;t<26;t++)
                    {
                        if((ch1[t]!=0 && ch2[t]==0) || (ch1[t]==0 && ch2[t]!=0))
                        {
                            count++;
                            break;
                        }
                    }
                
                    if(count==0)
                    {
                        res=str;
                    }
                }
            }
        }
        
        return res;
        
    }
}
