import java.math.BigInteger;

class Solution {
    public int sumDecoded(long[] nums) {
        BigInteger res = BigInteger.valueOf(0);
        for (int i = 0; i < nums.length; i++) {
            int width = (int) (nums[i] % 10);
            long d = nums[i] / 10;
            long x = 0, y = 0;
            String str = Long.toString(d);
            for (int j = 0; j < width; j++) {
                x = (x * 10) + str.charAt(j) - '0';
            }
            for (int j = width; j < str.length(); j++) {
                y = (y * 10) + str.charAt(j) - '0';
            }
            res = res.add(BigInteger.valueOf(x).modPow(BigInteger.valueOf(y), BigInteger.valueOf(1000000007)));
            res=res.mod(BigInteger.valueOf(1000000007));

        }

        return res.intValue();
    }
}
