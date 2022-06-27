class Solution {
    public int concatenatedBinary(int n) {
        if(n==1)
        {
            return 1;
        }
        else
        {
            long sum=1;
            for(int i=2;i<=n;i++)
            {
                int len=1+(int)(Math.log(i)/Math.log(2));
                sum=(sum*(int)Math.pow(2,len))+i;
                sum=sum%1000000007;
            }
             return (int)sum;
        }
        
    }
}
