class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buy=0,profit=0;
        int flag=0;
        for(int i=0;i<prices.length;i++)
        {
            if(flag==0)
            {
                flag=1;
                buy=buy+prices[i];
            }
            else
            {
                int temp=0;
                int f=0;
                if(prices[i]-profit<buy)
                {
                     temp=prices[i]-profit;
                     f=1;
                }
                if(prices[i]-buy-fee>profit)
                {
                    profit=prices[i]-buy-fee;
                    System.out.println(prices[i]+" "+buy+" "+profit);
                }
                if(f==1)
                {
                   buy=temp;
                }
            }
        }

        return profit;
    }
}
