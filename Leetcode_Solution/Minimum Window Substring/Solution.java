class Solution {
    public String minWindow(String s, String t) {
        String result="";
        if(t.length()>s.length())
        {
            return result;
        }
       
            if(t.equals(s))
            {
                return t;
            }
        
        int chtL[]=new int[26];
        int chtU[]=new int[26];
        for(int i=0;i<t.length();i++)
        {
            if(t.charAt(i)>='A' && t.charAt(i)<='Z')
            {
                chtU[t.charAt(i)-'A']++;
            }
            else
            {
                chtL[t.charAt(i)-'a']++;
            }
        }
        int cL[]=new int[26];
        int cU[]=new int[26];
        for(int k=0;k<t.length();k++)
            {
                if(s.charAt(k)>='A' && s.charAt(k)<='Z')
                {
                    cU[s.charAt(k)-'A']++;
                }
                else
                {
                    cL[s.charAt(k)-'a']++;
                }
            }
        for(int i=t.length()-1;i<s.length();i++)
        {
            int flag=0;
            int chL[]=new int[26];
            int chU[]=new int[26];
            if(i>t.length()-1)
            {
              if(s.charAt(i)>='A' && s.charAt(i)<='Z')
              {
                  cU[s.charAt(i)-'A']++;
              }
              else
              {
                  cL[s.charAt(i)-'a']++;
              }
            }
                for(int k=0;k<26;k++)
                {
                    chL[k]=cL[k];
                    chU[k]=cU[k];
                }
    
            for(int k=0;k<26;k++)
            {
                if(chL[k]<chtL[k])
                {
                   flag=1;
                    break;
                }
                if(chU[k]<chtU[k])
                {
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                result=s.substring(0,i+1);
                break;
            }
            for(int j=1;j<s.length()-i;j++)
            {
                flag=0;
                if(s.charAt(j-1)>='A' && s.charAt(j-1)<'Z')
                {
                    chU[s.charAt(j-1)-'A']--;
                }
                else
                {
                     chL[s.charAt(j-1)-'a']--;
                }
                if(s.charAt(j+i)>='A' && s.charAt(j+i)<='Z')
                {
                     chU[s.charAt(j+i)-'A']++;
                }
                else
                {
                     chL[s.charAt(j+i)-'a']++;
                }
               for(int k=0;k<26;k++)
               {
                if(chL[k]<chtL[k])
                {
                   flag=1;
                    break;
                }
                if(chU[k]<chtU[k])
                {
                    flag=1;
                    break;
                }
             }
            if(flag==0)
            {
                result=s.substring(j,j+i+1);
                break;
            }
            }
            if(result.length()>0)
            {
                break;
            }
        }
        
        return result;
        
      

    }
}
