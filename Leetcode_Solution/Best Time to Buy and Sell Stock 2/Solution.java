class Solution {
    public int maxProfit(int[] prices) {
        int buy=prices[0];
        int profit=0;
        int sell=-1;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]<=buy)
            {
                if(sell!=-1)
                {
                    profit+=sell-buy;
                    sell=-1;
                }
                buy=prices[i];
            }
            else
            {
                if(prices[i]<sell)
                {
                    profit+=sell-buy;
                    buy=prices[i];
                    sell=-1;
                }
                else
                {
                  sell=prices[i];
                }
            }
        }
        
        if(sell!=-1)
        {
            profit+=sell-buy;
        }
        return profit;
        
    }
}
