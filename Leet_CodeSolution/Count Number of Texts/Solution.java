class Solution {
    public int countTexts(String pressedKeys) {
     long dp[]=new long[pressedKeys.length()];
        dp[0]=1l;
        for(int i=1;i<pressedKeys.length();i++)
        {
            if(i==1)
            {
                if(pressedKeys.charAt(i)==pressedKeys.charAt(i-1))
                {
                    dp[i]=2;
                }
                else
                {
                    dp[i]=1;
                }
            }
            else if(i==2)
            {
                if(pressedKeys.charAt(i)==pressedKeys.charAt(i-1) && pressedKeys.charAt(i)==pressedKeys.charAt(i-2))
                {
                    dp[i]=dp[i-1]+dp[i-2]+1;
                }
                else
                {
                    if(pressedKeys.charAt(i)==pressedKeys.charAt(i-1))
                    {
                        dp[i]=dp[i-1]+dp[i-2];
                    }
                    else
                    {
                        dp[i]=dp[i-1];
                    }
                }
            }
            else
            {
                if(pressedKeys.charAt(i)!='7' && pressedKeys.charAt(i)!='9' )
                {
                     if(pressedKeys.charAt(i)==pressedKeys.charAt(i-1) && pressedKeys.charAt(i)==pressedKeys.charAt(i-2))
                    {
                        dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
                    }
                    else
                    {
                        if(pressedKeys.charAt(i)==pressedKeys.charAt(i-1))
                        {
                            dp[i]=dp[i-1]+dp[i-2];
                        }
                        else
                        {
                            dp[i]=dp[i-1];
                        }
                    }
                }
                else
                {
                   if(pressedKeys.charAt(i)==pressedKeys.charAt(i-1) && pressedKeys.charAt(i)==pressedKeys.charAt(i-2) && pressedKeys.charAt(i)==pressedKeys.charAt(i-3) )
                    {
                        if(i-4>=0)
                        {
                        dp[i]=dp[i-1]+dp[i-2]+dp[i-3]+dp[i-4];
                        }
                        else
                        {
                             dp[i]=dp[i-1]+dp[i-2]+dp[i-3]+1;
                        }
                    }
                    else if(pressedKeys.charAt(i)==pressedKeys.charAt(i-1) && pressedKeys.charAt(i)==pressedKeys.charAt(i-2))
                    {
                        dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
                    }
                    else
                    {
                        if(pressedKeys.charAt(i)==pressedKeys.charAt(i-1))
                        {
                            dp[i]=dp[i-1]+dp[i-2];
                        }
                        else
                        {
                            dp[i]=dp[i-1];
                        }
                    }
                }
            }
            dp[i]=dp[i]%(1000000007);
        }

        return (int)(dp[dp.length-1]);
    }
}
