class Solution {
    public int longestSubstring(String s, int k) {
        int ch[]=new int[26];
        for(int i=0;i<s.length();i++)
        {
            ch[s.charAt(i)-'a']++;
        }
        int flag=0;
        for(int i=0;i<26;i++)
        {
            if(ch[i]!=0 && ch[i]<k)
            {
                flag=1;
                break;
            }
        }
        if(flag==1)
        {
            int result=0;
            for(int i=s.length()-2;i>=0;i--)
            {
                ch[s.charAt(i+1)-'a']--;
                flag=0;
                for(int k1=0;k1<26;k1++)
                {
                    if(ch[k1]!=0 && ch[k1]<k)
                    {
                        flag=1;
                        break;
                    }
                }
                if(flag==0)
                {
                    result=i+1;
                    break;
                }
                else
                {
                    int c[]=new int[26];
                    for(int k1=0;k1<26;k1++)
                    {
                        c[k1]=ch[k1];
                    }
                for(int j=1;j<s.length()-i;j++)
                {
                    c[s.charAt(j-1)-'a']--;
                    c[s.charAt(j+i)-'a']++;
                    flag=0;
                for(int k1=0;k1<26;k1++)
                {
                    if(c[k1]!=0 && c[k1]<k)
                    {
                        flag=1;
                        break;
                    }
                }
                if(flag==0)
                {
                    result=i+1;
                    break;
                }
                }
              }
                if(result!=0)
                {
                    break;
                }
            }
            
            return result;
        }
        else
        {
            return s.length();
        }
    }
}
