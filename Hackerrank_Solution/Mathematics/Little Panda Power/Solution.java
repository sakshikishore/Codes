import java.util.*;
import java.math.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        for(int i=0;i<t;i++)
        {
        BigInteger a=scan.nextBigInteger();
        BigInteger b=scan.nextBigInteger();
        BigInteger c=scan.nextBigInteger();
        BigInteger s=a.modPow(b,c);
        System.out.println(s);
        }
    }
}
