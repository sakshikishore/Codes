class Solution {
    public int minCost(int n) {
        if (n <= 2) {
            return n - 1;
        }
        int dp[] = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= i / 2; j++) {
                int p=i-j;
                min=Math.min(min,(p*j)+dp[p]+dp[j]);
            }

            dp[i]=min;
        }

        return dp[n];

    }
}
