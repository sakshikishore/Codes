import java.math.BigInteger;
class Solution {
    public int numSubseq(int[] nums, int target) {
        BigInteger result=BigInteger.valueOf(0);
        BigInteger m=BigInteger.valueOf(1000000007);
        Arrays.sort(nums);
        int i=0,j=nums.length-1;
        while(i<=j)
        {
             if(nums[i]+nums[j]<=target)
             {
                 int p=j-i;
                 result=result.add(BigInteger.valueOf(2).modPow(BigInteger.valueOf(p),m));
                 result=result.mod(m);
                 i++;
             }
             else
             {
                 j--;
             }
        }
        return result.intValue();
    }
}
