class Solution {
    public int beautySum(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++)
        {
            int ch[]=new int[26];
            String str=s.substring(i,i+1);
            ch[s.charAt(i)-'a']++;
            int min=Integer.MAX_VALUE;
            int max=1;
            for(int j=i+1;j<s.length();j++)
            {
                str=str+s.substring(j,j+1);
                ch[s.charAt(j)-'a']++;
                if(ch[s.charAt(j)-'a']>max)
                {
                    max=ch[s.charAt(j)-'a'];       
                }
               for(int p=0;p<26;p++)
               {
                   if(ch[p]!=0)
                   {
                       if(ch[p]<min)
                       {
                           min=ch[p];
                       }
                   }
               }
                sum=sum+(max-min);
                min=Integer.MAX_VALUE;
                
            }
        }
        return sum;
    }
}
