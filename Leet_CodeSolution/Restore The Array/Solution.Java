class Solution {
    public int numberOfArrays(String s, int k) {
        if(s.charAt(0)=='0' || (s.charAt(0)-'0')>k)
        {
            return 0;
        }
        int x=k;
        int count=0;
        while(x>0)
        {
            count++;
            x=x/10;
        }
        long dp[]=new long[s.length()];
        dp[0]=1l;
        for(int i=1;i<s.length();i++)
        {
            x=0;
            long val=0;
            for(int j=i;j>=0 && j>=i-count;j--)
            {
                int p=s.charAt(j)-'0';
                val=(p*(long)Math.pow(10,x))+val;
                x++;
                if(p!=0 && val!=0 && val<=k)
                {
                   if(j==0)
                   {
                    dp[i]+=1l;
                   }
                   else
                   {
                    dp[i]+=dp[j-1];
                   }
                }
            }
            if(dp[i]==0)
            {
                return 0;
            }
            dp[i]=dp[i]%(1000000007);
        }

        return (int)(dp[dp.length-1]);
    }
}
