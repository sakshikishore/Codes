class Solution {
    public String removeDuplicateLetters(String s) {
        int ch[]=new int[26];
        for(int i=0;i<s.length();i++)
        {
            ch[s.charAt(i)-'a']++;
        }
        int c[]=new int[26];
        String res="";
        for(int i=0;i<s.length();i++)
        {
            if(i==0)
            {
                res=res+s.substring(i,i+1);
                c[s.charAt(i)-'a']++;
            }
            else
            {
               if(res.contains(s.substring(i,i+1)))
               {
                   c[s.charAt(i)-'a']++;
                   continue;
               }
               else
               {
                   char a=res.charAt(res.length()-1);
                   if(s.charAt(i)<a)
                   {
                       int flag=0;
                       while(s.charAt(i)<a)
                       {
                           if(c[a-'a']<ch[a-'a'])
                           {
                               res=res.substring(0,res.length()-1);
                           }
                           else
                           {
                              
                               res=res+s.substring(i,i+1);
                               c[s.charAt(i)-'a']++;
                               flag=1;
                               break;
                           }
                           if(res.length()==0)
                           {
                              res=res+s.substring(i,i+1);
                              c[s.charAt(i)-'a']++;
                               flag=1;
                               break;
                           }
                           a=res.charAt(res.length()-1);
                       }
                       if(flag==0)
                       {
                           res=res+s.substring(i,i+1);
                             c[s.charAt(i)-'a']++;
                       }
                   }
                   else
                   {
                       res=res+s.substring(i,i+1);
                          c[s.charAt(i)-'a']++;
                   }
               }
            }
        }
        
        return res;
    }
}
