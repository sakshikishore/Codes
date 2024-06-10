class Solution {
    public int minimumSubstringsInPartition(String s) {
        int dp[]=new int[s.length()];
        dp[0]=1;
        for(int i=1;i<s.length();i++)
        {
            int ch[]=new int[26];
            dp[i]=dp[i-1]+1;
            for(int j=i-1;j>=0;j--)
            {
                ch[s.charAt(j+1)-'a']++;
                int p=ch[s.charAt(j+1)-'a'];
                int flag=0;
                for(int k=0;k<26;k++)
                {
                    if(ch[k]!=0)
                    {
                        if(ch[k]!=p)
                        {
                            flag=1;
                            break;
                        }
                    }
                }
                if(flag==0)
                {
                    if(dp[j]+1<dp[i])
                    {
                        dp[i]=dp[j]+1;
                    }
                }
            }
            ch[s.charAt(0)-'a']++;
            int p=ch[s.charAt(0)-'a'];
                int flag=0;
                for(int k=0;k<26;k++)
                {
                    if(ch[k]!=0)
                    {
                        if(ch[k]!=p)
                        {
                            flag=1;
                            break;
                        }
                    }
                }
                if(flag==0)
                {
                    dp[i]=1;
                }
        }

        return dp[s.length()-1];
    }
}
