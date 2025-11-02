class Solution {
    public long removeZeros(long n) {
        long p=0,ans=0;
        while(n>0)
        {
            long r=n%10;
            if(r!=0)
            {
                ans=r*(long)(Math.pow(10,p))+ans;
                p++;
            }
            n=n/10;
        }

        return ans;
    }
}
