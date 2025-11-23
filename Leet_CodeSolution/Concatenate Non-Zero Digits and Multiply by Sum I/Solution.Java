class Solution {
    public long sumAndMultiply(int n) {
        long x=0;
        long sum=0;
        int i=0;
        while(n>0)
        {
            long r=n%10;
            if(r!=0)
            {
                sum=sum+r;
                x=r*(long)Math.pow(10,i)+x;
                i++;
            }
            n=n/10;
        }

        return sum*x;
    }
}
