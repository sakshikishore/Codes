class Solution {
    public long countCommas(long n) {
        if(n<1000)
        {
            return 0;
        }
        long res=0;
        boolean flag=true;
        long p=1000,q=10000;
        int c=1,count=0;
        while(flag)
        {
            if(n>=p && n>=q)
            {
                res+=(q-p)*c;
            }
            else
            {
                break;
            }
            p=p*10;
            q=q*10;
            count++;
            if(count==3)
            {
                c++;
                count=0;
            }
        }
        res+=(n-p+1)*c;

        return res;
    }
}
