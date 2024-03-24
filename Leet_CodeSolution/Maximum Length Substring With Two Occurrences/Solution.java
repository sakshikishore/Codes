class Solution {
    public int maximumLengthSubstring(String s) {
        int max=0;
        for(int i=0;i<s.length();i++)
        {
            int ch[]=new int[26];
            for(int j=i;j<s.length();j++)
            {
                ch[s.charAt(j)-'a']++;
                int flag=0;
                for(int k=0;k<26;k++)
                {
                    if(ch[k]!=0 && ch[k]>2)
                    {
                        flag=1;
                        break;
                    }
                }
                if(flag==0 && ((j+1)-i)>max)
                {
                    max=(j+1)-i;
                }
            }
        }
        
        return max;
    }
}
