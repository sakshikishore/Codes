class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==1)
        {
            return 0;
        }
        int buy=prices[0],sell=0,c=0;
        int prevSell=0;
        for(int i=1;i<prices.length;i++)
        {
            int flag=0;
            int temp=0;
            if(c==0)
            {
                if(prices[i]-sell<buy)
                {
                    temp=prices[i]-sell;
                    flag=1;
                }
            }
            else
            {
                if(prices[i]-prevSell<buy)
                {
                    temp=prices[i]-prevSell;
                    flag=1;
                }
            }
            if(prices[i]-buy>sell)
            {
                prevSell=sell;
                sell=prices[i]-buy;
                c=1;
            }
            else
            {
                c=0;
            }
            if(flag==1)
            {
                buy=temp;
            }
        }

        return sell;
    }
}
