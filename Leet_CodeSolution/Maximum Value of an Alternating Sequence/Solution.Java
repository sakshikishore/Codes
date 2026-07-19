class Solution {
    public long maximumValue(int n, int s, int m) {
        if(n==1)
        {
            return s*1l;
        }
        if (n % 2 == 0) {
            long a=s+m;
            long d=m-1;
            n=n/2;
            return (a+(n-1)*d);
        }
        else
        {
            long a=s;
            long d=m-1;
            n=(n/2)+1;
            return (a+(n-1)*d)+1;
        }
    }
}
