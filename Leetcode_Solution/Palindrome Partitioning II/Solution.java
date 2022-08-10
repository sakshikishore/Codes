class Solution {
    public int minCut(String s) {
        int dp[]=new int[s.length()];
        if(s.length()==1)
        {
            return 0;
        }
        else
        {
            for(int i=0;i<s.length();i++)
            {
                String str=s.substring(0,i+1);
                StringBuffer sb=new StringBuffer(str);
                String p=new String(sb.reverse());
                if(p.equals(str))
                {
                    dp[i]=0;
                }
                else
                {
                    int max=2001;
                    for(int j=i;j>=1;j--)
                    {
                        String s1=str.substring(j);
                        sb=new StringBuffer(s1);
                        p=new String(sb.reverse());
                        if(p.equals(s1))
                        {
                            if(dp[j-1]+1<max)
                            {
                                max=dp[j-1]+1;
                            }
                        }
                    }
                    dp[i]=max;
                }
            }
        }
    
        return dp[dp.length-1];
    }
}
