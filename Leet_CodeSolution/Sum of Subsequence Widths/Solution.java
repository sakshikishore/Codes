import java.math.BigInteger;
class Solution {
    public int sumSubseqWidths(int[] nums) {
       BigInteger ans=BigInteger.valueOf(0);
       BigInteger m=BigInteger.valueOf(1000000007);
        Arrays.sort(nums);
       BigInteger p=(BigInteger.valueOf(1).subtract(BigInteger.valueOf(2).modPow(BigInteger.valueOf(nums.length-1),m))).divide(BigInteger.valueOf(-1));
       ans=ans.subtract(BigInteger.valueOf(nums[0]).multiply(p));
         ans=ans.mod(m);
        for(int i=1;i<nums.length;i++)
        {
            p=(BigInteger.valueOf(1).subtract(BigInteger.valueOf(2).modPow(BigInteger.valueOf(nums.length-i-1),m))).divide(BigInteger.valueOf(-1));
            ans=ans.subtract(BigInteger.valueOf(nums[i]).multiply(p));
            ans=ans.mod(m);
           
            p=(BigInteger.valueOf(1).subtract(BigInteger.valueOf(2).modPow(BigInteger.valueOf(i),m))).divide(BigInteger.valueOf(-1));
            ans=ans.add(BigInteger.valueOf(nums[i]).multiply(p));
              ans=ans.mod(m);
        
        }
       
      return ans.intValue();
        
    }
}
