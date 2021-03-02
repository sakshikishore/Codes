import java.math.BigInteger;
class Solution {
    public int numPrimeArrangements(int n) {
        int p=0; // Total Prime
        for(int i=1;i<=n;i++)
        {
            if(BigInteger.valueOf(i).isProbablePrime(10))
            {
                p++;
            }
        }
        // result= factorial(Total Prime)* factorial(Total non Prime)
        int np=n-p; // Total non Prime
        long result=1;
        for(int i=1;i<=np;i++)
        {
            result=result*i;
            result=result%(1000000007);
        }
        for(int i=1;i<=p;i++)
        {
            result=result*i;
            result=result%(1000000007);
        }
        return (int)result;
    }
}
