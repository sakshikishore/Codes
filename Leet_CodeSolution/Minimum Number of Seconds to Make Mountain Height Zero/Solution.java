import java.math.BigInteger;
class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
       Arrays.sort(workerTimes);
       BigInteger result=BigInteger.valueOf(0);
       BigInteger a=BigInteger.valueOf(workerTimes[0]);
       BigInteger n=BigInteger.valueOf(mountainHeight);
      BigInteger min=BigInteger.valueOf(1), max=(n.multiply((a.multiply(n)).add(a))).divide(BigInteger.valueOf(2));
       while(min.compareTo(max)==-1 || min.compareTo(max)==0)
       {
          BigInteger mid=(min.add(max)).divide(BigInteger.valueOf(2));
          BigInteger total=BigInteger.valueOf(0);
          for(int i=0;i<workerTimes.length;i++)
          {
            BigInteger wTime=BigInteger.valueOf(workerTimes[i]);
            BigInteger c=BigInteger.valueOf(2).multiply(mid);// an*n+bn+c || (n*(2a+(n-1)*d)/2)=mid;
          
            BigInteger r=((BigInteger.valueOf(-1).multiply(wTime)).add(((wTime.multiply(wTime)).add(BigInteger.valueOf(4).multiply(wTime.multiply(c)))).sqrt())).divide(BigInteger.valueOf(2).multiply(wTime));
            if(r.compareTo(BigInteger.valueOf(0))==1)
            {
                total=total.add(r);
            }
            if(total.compareTo(n)==1 || total.compareTo(n)==0 )
            {
                break;
            }
          }
           if(total.compareTo(n)==1 || total.compareTo(n)==0 )
            {
               result=mid;
               max=mid.subtract(BigInteger.valueOf(1));
            }
            else
            {
                min=mid.add(BigInteger.valueOf(1));
            }
       }

       return result.longValue();
    }
}
