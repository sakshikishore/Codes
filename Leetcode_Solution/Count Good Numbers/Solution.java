import java.math.BigInteger;
class Solution {
    public int countGoodNumbers(long n) {
        BigInteger b1=BigInteger.valueOf(5);
        BigInteger b2=BigInteger.valueOf(4);
        BigInteger x=BigInteger.valueOf(1000000007);
        if(n%2==0)
        {
           long mid=n/2;
           BigInteger m=BigInteger.valueOf(mid);
           BigInteger a=b1.modPow(m,x);
           BigInteger b=b2.modPow(m,x);
           BigInteger c=a.multiply(b);
           c=c.mod(x);
           return c.intValue();
            
        }
        else
        {
           long mid=n/2;
           BigInteger m1=BigInteger.valueOf(mid+1);
           BigInteger m2=BigInteger.valueOf(mid);
           BigInteger a=b1.modPow(m1,x);
           BigInteger b=b2.modPow(m2,x);
           BigInteger c=a.multiply(b);
           c=c.mod(x);
           return c.intValue();
        }
    }
}
