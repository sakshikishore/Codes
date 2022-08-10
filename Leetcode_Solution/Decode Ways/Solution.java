class Solution {
    public int numDecodings(String s) {
        int ans=0;
        int dp[]=new int[s.length()];
        for(int i=0;i<s.length();i++)
        {
            if(i==0 && s.charAt(i)=='0')
            {
                break;
            }
            else
            {
                if(i==0)
                {
                    dp[i]=1;
                }
                else if(i==1)
                {
                    if(s.charAt(i)=='0')
                    {
                        if(s.charAt(i-1)<'3')
                        {
                            dp[i]=1;
                        }
                    }
                    else
                    {
                        int x=Integer.parseInt(s.substring(0,2));
                        if(x<27)
                        {
                            dp[i]=1;
                            dp[i]+=dp[i-1];
                        }
                        else
                        {
                            dp[i]=dp[i-1];
                        }
                        
                    }
                }
                else
                {
                    if(s.charAt(i)=='0')
                    {
                        if(s.charAt(i-1)=='0')
                        {
                            continue;
                        }
                        else
                        {
                            if(s.charAt(i-1)<'3')
                            {
                                dp[i]=dp[i-2];
                            }
                        }
                    }
                    else
                    {
                        dp[i]=dp[i-1];
                        if(s.charAt(i-1)!='0')
                        {
                            int a=Integer.parseInt(s.substring(i-1,i+1));
                            if(a<27 && a>=0)
                            {
                                dp[i]+=dp[i-2];
                            }
                        }
                    }
                }
            }
        }
        
        return dp[dp.length-1];
    }
}
