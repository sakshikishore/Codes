import java.math.BigInteger;
class Solution {
    public int knightDialer(int n) {
        if(n==1)
        {
            return 10;
        }
        else
        {
            BigInteger p=BigInteger.valueOf(1);
            BigInteger q=BigInteger.valueOf(0);
            BigInteger m =BigInteger.valueOf(1000000007);
            BigInteger a0=p,a1=p,a2=p,a3=p,a4=p,a6=p,a7=p,a8=p,a9=p;
            BigInteger sum=q;
            for(int i=2;i<=n;i++)
            {
               BigInteger b0=q,b1=q,b2=q,b3=q,b4=q,b6=q,b7=q,b8=q,b9=q;
                for(int j=0;j<10;j++)
                {
                    if(j==0)
                    {
                       b6=b6.add(a0);
                       b4=b4.add(a0);
                    }
                    else if(j==1)
                    {
                       
                       b8=b8.add(a1);
                       b6=b6.add(a1);
                    }
                    else if(j==2)
                    {
                       b7=b7.add(a2);
                       b9=b9.add(a2);
                    }
                     else if(j==3)
                    {
                       b8=b8.add(a3);
                       b4=b4.add(a3);
                    }
                    else if(j==4)
                    {
                       b3=b3.add(a4);
                       b9=b9.add(a4);
                       b0=b0.add(a4);
                    }
                     else if(j==6)
                    {
                       b1=b1.add(a6);
                      b7= b7.add(a6);
                       b0=b0.add(a6);
                    }
                    else if(j==7)
                    {
                       b2=b2.add(a7);
                       b6=b6.add(a7);
                    }
                     else if(j==8)
                    {
                       b1=b1.add(a8);
                       b3=b3.add(a8);
                    }
                    else if(j==9)
                    {
                       b4=b4.add(a9);
                       b2=b2.add(a9);
                    }
                }
                a0=b0;
                a0=a0.mod(m);
                a1=b1;
                a1=a1.mod(m);
                a2=b2;
                a2=a2.mod(m);
                a3=b3;
                a3=a3.mod(m);
                a4=b4;
                a4=a4.mod(m);
                a6=b6;
                a6=a6.mod(m);
                a7=b7;
                a7=a7.mod(m);
                a8=b8;
                a8=a8.mod(m);
                a9=b9;
                a9=a9.mod(m);
                if(i==n)
                {
                   sum=sum.add(a0);
                   sum=sum.mod(BigInteger.valueOf(1000000007));
                   sum=sum.add(a1);
                   sum=sum.mod(BigInteger.valueOf(1000000007));
                   sum=sum.add(a2);
                    sum=sum.mod(BigInteger.valueOf(1000000007));
                   sum=sum.add(a3);
                    sum=sum.mod(BigInteger.valueOf(1000000007));
                  sum= sum.add(a4);
                   sum=sum.mod(BigInteger.valueOf(1000000007));
                   sum=sum.add(a6);
                    sum=sum.mod(BigInteger.valueOf(1000000007));
                   sum=sum.add(a7);
                    sum=sum.mod(BigInteger.valueOf(1000000007));
                   sum=sum.add(a8);
                    sum=sum.mod(BigInteger.valueOf(1000000007));
                   sum=sum.add(a9);
                    sum=sum.mod(BigInteger.valueOf(1000000007));

                }
            }
            sum=sum.mod(BigInteger.valueOf(1000000007));
           
            return sum.intValue();
        
        }
    }
}
