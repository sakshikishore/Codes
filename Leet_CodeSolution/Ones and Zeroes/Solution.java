class Solution {
    int dp[][][]=new int[600][101][101];
    public int getSolution(String[] strs,int index, int m, int n, int mcount, int ncount)
    {
        if(index==strs.length)
        {
            return 0;
        }
        if(dp[index][mcount][ncount]!=0)
        {
            return dp[index][mcount][ncount];
        }
        int a=getSolution(strs,index+1,m,n,mcount,ncount);
        int b=0,score=0;
        String s=strs[index];
        int flag=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='0')
            {
                mcount++;
            }
            else
            {
                ncount++;
            }
            if(mcount>m || ncount>n)
            {
                flag=1;
            }
        }
        if(flag==0)
        {
            b=1+getSolution(strs,index+1,m,n,mcount,ncount);
        }
         for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='0')
            {
                mcount--;
            }
            else
            {
                ncount--;
            }
        }
        
        return dp[index][mcount][ncount]=Math.max(a,b);
        
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int mcount=0,ncount=0;
        return getSolution(strs,0,m,n,mcount,ncount);
    }
}
