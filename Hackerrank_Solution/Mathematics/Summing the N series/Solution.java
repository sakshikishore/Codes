import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.math.BigInteger;

public class Solution 
{
  public static void main(String args[])
  {
    Scanner scan=new Scanner(System.in);
    long p=1000000007;
    int t=scan.nextInt();
    for(int i=0;i<t;i++)
    {
        BigInteger n=scan.nextBigInteger();
        System.out.println((n.multiply(n)).mod(BigInteger.valueOf(p)));
    }
  }
}

