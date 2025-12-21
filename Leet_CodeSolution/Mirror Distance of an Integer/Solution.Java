class Solution {
    public int mirrorDistance(int n) {
        int r=n;
        int rev=0;
        while(r>0)
        {
            rev=rev*10+(r%10);
            r=r/10;
        }
        return Math.abs(n-rev);
    }
}
