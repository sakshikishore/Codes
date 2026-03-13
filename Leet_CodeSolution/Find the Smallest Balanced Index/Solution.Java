import java.math.BigInteger;

class Solution {
    public int smallestBalancedIndex(int[] nums) {
        if (nums.length == 1) {
            return -1;
        }
        long totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }
        BigInteger prod = BigInteger.valueOf(1);
        int index = 0;
        long suf[] = new long[nums.length];
        BigInteger s = BigInteger.valueOf(totalSum);
        for (int i = nums.length - 1; i >= 0; i--) {
            prod = prod.multiply(BigInteger.valueOf(nums[i]));
            if (prod.compareTo(s) > 0) {
                index = i;
                break;
            }
            suf[i] = prod.longValue();
        }
        long sum = 0;
        for (int j = 0; j < index; j++) {
            sum += nums[j];
        }
        for (int j = index; j < nums.length; j++) {
            if (j == nums.length - 1) {
                if (sum == 1) {
                    return nums.length - 1;
                }
            } else {
                if (sum == suf[j + 1]) {
                    return j;
                }
            }
            sum += nums[j];
        }

        return -1;

    }
}
