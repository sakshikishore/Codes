class Solution {
    public int maxProfit(int[] prices) {
         int profit=0;
        if(prices.length>0)
        {
            
        
        int max=prices[prices.length-1];
       
        for(int i=prices.length-1;i>=0;i--)
        {
            if(prices[i]>max)
            {
                max=prices[i];
            }
            if(max-prices[i]>profit)
            {
                profit=max-prices[i];
            }
        }
        }
        
        return profit;
    }
}
