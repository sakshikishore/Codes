import java.math.BigInteger;

class Solution {
    public int minimumCost(int[] nums, int k) {
        long resource = k * 1l;
        long totalCost = 0;
        long p = 1;
        for (int i = 0; i < nums.length; i++) {
            if (resource - nums[i] >= 0) {
                resource = resource - nums[i];
            } else {
                long l = nums[i] - resource;
                long q = l / k;
                long r = l % k;
                if (r > 0) {
                    q = q + 1;
                }

                resource = resource + (q * k);
                resource = resource - nums[i];
                BigInteger cost = (BigInteger.valueOf(q).multiply(
                        (BigInteger.valueOf(2).multiply(BigInteger.valueOf(p))).add(BigInteger.valueOf(q - 1))))
                        .divide(BigInteger.valueOf(2));
                cost = cost.mod(BigInteger.valueOf(1000000007));
                totalCost += cost.intValue();
                totalCost = totalCost % (1000000007);
                p = p + q;
            }
        }

        return (int) totalCost;
    }
}
