import java.math.BigInteger;
class Solution {
    public int distinctSubseqII(String s) {
        BigInteger dp[]=new BigInteger[s.length()];
        dp[0]=BigInteger.valueOf(1);
        HashMap<Character,Integer> h=new HashMap<Character,Integer>();
        h.put(s.charAt(0),0);
        for(int i=1;i<s.length();i++)
        {
            if(!h.containsKey(s.charAt(i)))
            {
                h.put(s.charAt(i),i);
                dp[i]=(BigInteger.valueOf(2).multiply(dp[i-1])).add(BigInteger.valueOf(1));
            }
            else
            {
                int index=h.get(s.charAt(i));
                if(index==0)
                {
                    dp[i]=(BigInteger.valueOf(2).multiply(dp[i-1]));
                }
                else
                {
                   dp[i]=dp[i-1].add((dp[i-1].subtract(dp[index-1])));
                }
                  h.put(s.charAt(i),i);
            }
        }
        dp[s.length()-1]=dp[s.length()-1].mod(BigInteger.valueOf(1000000007));
        return dp[s.length()-1].intValue();
    }
}
