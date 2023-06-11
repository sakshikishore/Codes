class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int max=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.length()-i<max)
            {
                break;
            }
            for(int j=s.length();j>=i+1;j--)
            {
                String str=s.substring(i,j);
                int flag=0;
                for(int k=1;k<str.length();k++)
                {
                    if(str.charAt(k)==str.charAt(k-1))
                    {
                        flag++;
                        if(flag==2)
                        {
                            break;
                        }
                    }
                }
                if(flag<2)
                {
                    if(str.length()>max)
                    {
                        max=str.length();
                    }
                    break;
                }
            }
        }
        
        return max;
    }
}
