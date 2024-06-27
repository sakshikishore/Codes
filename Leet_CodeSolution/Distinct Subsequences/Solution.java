class Solution {
    public int Solve(String s, String t,int sIndex,int tIndex,int dp[][])
    {
        if(tIndex==t.length())
        {
           return 1;
        }
        if(sIndex>=s.length())
        {
            return 0;
        }
        if(dp[sIndex][tIndex]!=-1)
        {
           return dp[sIndex][tIndex];
        }
        dp[sIndex][tIndex]=0;
       for(int j=sIndex;j<s.length()-(t.length()-1-tIndex);j++)
       {
            if(s.charAt(j)==t.charAt(tIndex))
            {
                dp[sIndex][tIndex]+=Solve(s,t,j+1,tIndex+1,dp);
            }
       }
       return dp[sIndex][tIndex];
    }
    public int numDistinct(String s, String t) {
        if(t.length()>s.length())
        {
            return 0;
        }
        if(t.equals(s))
        {
            return 1;
        }
        int dp[][]=new int[s.length()+1][t.length()+1];
        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return Solve(s,t,0,0,dp);
        
    }
}
