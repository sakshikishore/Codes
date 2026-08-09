class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        double result = 0.0;
        Arrays.sort(prices);
        Arrays.sort(discounts);
        int j = discounts.length - 1, i = prices.length - 1;
        while (j >= 0 && i >= 0) {
            double price = (prices[i] * (100 - discounts[j])) / 100.0;
            result += price;
            i--;
            j--;
        }
        while (i >= 0) {
            result += prices[i];
            i--;
        }

        return result;
    }
}
