import java.math.BigInteger;
class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        HashMap<Integer,BigInteger> map=new HashMap<Integer,BigInteger>();
        BigInteger result=BigInteger.valueOf(0);
        if(forget+1>n)
        {
            result=BigInteger.valueOf(1);
        }
        map.put(1,BigInteger.valueOf(1));
        for(int i=1;i<=n;i++)
        {
            if(map.containsKey(i))
            {
                BigInteger count=map.get(i);
                int p=i+delay;
                if(p<=n)
                {
                    for(int x=p;x<i+forget;x++)
                    {
                        if(x<=n)
                        {
                            if(x+forget>n)
                            {
                              result=result.add(count);
                              result=result.mod(BigInteger.valueOf(1000000007));
                            }
                            if(!map.containsKey(x))
                            {
                                map.put(x,count);
                            }
                            else
                            {
                                map.put(x,map.get(x).add(count));
                            }
                        }
                        
                }
                }
            }
        }

        return result.intValue();
    }
}
