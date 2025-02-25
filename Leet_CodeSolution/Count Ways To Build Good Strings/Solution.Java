class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        long dp[] = new long[high + 1];
        if (zero == one) {
            dp[zero] = 2l;
        } else {
            dp[zero] = 1l;
            dp[one] = 1l;
        }
        long sum = 0;
        int min = Math.min(zero, one);
        if (min >= low) {
            sum += dp[min];
        }
        for (int i = min + 1; i <= high; i++) {
            if (i - one >= 0) {
                dp[i] += dp[i - one];
                if (dp[i] > Integer.MAX_VALUE) {
                    dp[i] = dp[i] % (1000000007);
                }
            }
            if (i - zero >= 0) {
                dp[i] += dp[i - zero];
                if (dp[i] > Integer.MAX_VALUE) {
                    dp[i] = dp[i] % (1000000007);
                }
            }
            if (i >= low) {
                sum += dp[i];
                sum = sum % (1000000007);
            }
        }

        return (int) sum;

    }
}
