class Solution {
    public String modifyString(String s) {
        int ch[]=new int[26];
        for(int i=0;i<26;i++)
        {
            ch[i]=i;
        }
        for(int i=0;i<s.length();i++)
        {
            if(i==0 && s.charAt(i)=='?')
            {
                if(s.length()>1)
                {
                    if(s.charAt(1)=='a')
                    {
                        s="b"+s.substring(1);
                    }
                    else
                    {
                        s="a"+s.substring(1);
                    }
                }
                else
                {
                    s="a";
                }
                    
            }
            else if(i==s.length()-1 && s.charAt(i)=='?')
            {
                if(s.charAt(i-1)=='a')
                {
                    s=s.substring(0,s.length()-1)+"b";
                }
                else
                {
                   s=s.substring(0,s.length()-1)+"a"; 
                }
            }
            else
            {
                if(s.charAt(i)=='?')
                {
                int p= ch[s.charAt(i-1)-'a'];
                int q=-1;
               if(s.charAt(i+1)!='?')
               {
                q=ch[s.charAt(i+1)-'a'];
               }
                for(int j=0;j<3;j++)
                {
                    if(p!=j && q!=j)
                    {
                        s=s.substring(0,i)+Character.toString((char)(j+97))+s.substring(i+1);
                        break;
                    }
                }
            }
            }
        }
        
        return s;
        
    }
}
