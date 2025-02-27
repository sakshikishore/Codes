class Solution {
    public int numOfArrays(int n, int m, int k) {
        if (m < k) {
            return 0;
        }
        if (m == 1) {
            return 1;
        }
        long dp[][][] = new long[n][m][k];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                for (int j = 0; j < m; j++) {
                    dp[i][j][0] = 1l;
                }
            } else {
                for (int j = 0; j < m; j++) {
                    for (int t = 0; t < m; t++) {
                        if (t < j) {
                            for (int x = 0; x < k - 1; x++) {
                                dp[i][j][x + 1] += dp[i - 1][t][x];
                                dp[i][j][x + 1] = dp[i][j][x + 1] % (1000000007);
                            }
                        } else {
                            for (int x = 0; x < k; x++) {
                                dp[i][t][x] += dp[i - 1][t][x];
                                dp[i][t][x] = dp[i][t][x] % (1000000007);

                            }
                        }
                    }
                }
            }
        }
        long result = 0;
        for (int j = 0; j < m; j++) {
            result += dp[n - 1][j][k - 1];
            result = result % (1000000007);
        }

        return (int) result;

    }
}
