class Solution {
    boolean res=false;
    public void Solve(String s1,int i,String s2, int j, String s3,int k, int dp[][][])
    {
        if(k==s3.length() && i==s1.length() && j==s2.length())
        {
            res=true;
            return;
        }
        if(dp[i][j][k]==1)
        {
            return;
        }
        dp[i][j][k]=1;
        if(i<s1.length() && k<s3.length())
        {
            if(s1.charAt(i)==s3.charAt(k))
            {
                Solve(s1,i+1,s2,j,s3,k+1,dp);
            }
        }
        if(j<s2.length() && k<s3.length())
        {
            if(s2.charAt(j)==s3.charAt(k))
            {
                 Solve(s1,i,s2,j+1,s3,k+1,dp);
            }
        }

    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int dp[][][]=new int[101][101][201];
        if(s1.length()+s2.length()<s3.length())
        {
            return false;
        }
        Solve(s1,0,s2,0,s3,0,dp);

        return res;
    }
}
