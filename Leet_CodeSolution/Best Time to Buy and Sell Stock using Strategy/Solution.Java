class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long profit = 0;
        for (int i = 0; i < prices.length; i++) {
            profit += strategy[i] * prices[i];
        }
        long result = profit;
        for (int i = 0; i < k; i++) {
            profit = profit - (strategy[i] * prices[i]);
            if (i >= k / 2) {
                profit += prices[i];
            }
        }
        int j = k / 2;
        result = Math.max(profit, result);
        for (int i = 1; i <= prices.length - k; i++) {
            profit += strategy[i - 1] * prices[i - 1];
            profit = profit - prices[j];
            profit = profit - (strategy[i + k - 1] * prices[i + k - 1]);
            profit = profit + prices[i + k - 1];
            j++;
            result = Math.max(profit, result);
        }

        return result;
    }
}
