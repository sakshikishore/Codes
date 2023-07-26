class Solution {
    public int numOfWays(int n) {
        long same2=6,same3=6;
        for(int i=2;i<=n;i++)
        {
            long temp2=2l*same3+3*same2;
            long temp3=2*same3+2*same2;
            same2=temp2%1000000007;
            same3=temp3%1000000007;
        }

         long result=(same2+same3)%1000000007;
        return (int)result;
    }
}
