class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int ch[]=new int[26];
        boolean result=false;
        for(int i=0;i<s1.length();i++)
        {
            ch[s1.charAt(i)-'a']++;
        }
        int c[]=new int[26];
        int n=s1.length();
        for(int i=0;i<s2.length();i++)
        {
             if(i<n)
             {
                 c[s2.charAt(i)-'a']++;
             }
             else
             {
                 int flag=0;
                 for(int j=0;j<26;j++)
                 {
                     if(ch[j]!=c[j])
                     {
                         flag=1;
                         break;
                     }
                 }
                 if(flag==0)
                 {
                     result=true;
                     break;
                 }
                 c[s2.charAt(i-n)-'a']--;
                 c[s2.charAt(i)-'a']++;
             }
        }
                 if(!result)
                 {
                     int flag=0;
                     for(int j=0;j<26;j++)
                     {
                         if(ch[j]!=c[j])
                         {
                             flag=1;
                             break;
                         }
                     }
                     if(flag==0)
                     {
                         result=true;
                     }
                 }
        
        return result;
    }
}
