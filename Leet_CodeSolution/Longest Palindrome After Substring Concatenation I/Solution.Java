class Solution {
    public int longestPalindrome(String s, String t) {
        int max=1;
        for(int i=0;i<s.length();i++)
        {
            for(int j=i;j<=s.length();j++)
            {
                String str1=s.substring(i,j);
                for(int k=0;k<t.length();k++)
                {
                    for(int l=k;l<=t.length();l++)
                    {
                         String str2=t.substring(k,l);
                         String p=str1+str2;
                         StringBuffer sb=new StringBuffer(p);
                         String q=new String(sb.reverse());
                         if(p.equals(q))
                         {
                            if(p.length()>max)
                            {
                                max=p.length();
                            }
                         }
                    }
                }
                
            }
        }
    

        return max;
    }
}
