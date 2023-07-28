class Solution {
    public int maxProfit(int[] prices) {
        int arr1[]=new int[prices.length];
        int arr2[]=new int[prices.length];
        int maxSell=0;
        int min=prices[0];
        for(int i=1;i<prices.length;i++)
        {
             if(prices[i]-min>maxSell)
             {
                 maxSell=prices[i]-min;
             }
             arr1[i]=maxSell;
             if(prices[i]<min)
             {
                 min=prices[i];
             }
        }
       int max=prices[prices.length-1];
        maxSell=0;
        for(int i=prices.length-2;i>=0;i--)
        {
           if(max-prices[i]>maxSell)
           {
               maxSell=max-prices[i];
           }
           arr2[i]=maxSell;
           if(prices[i]>max)
           {
               max=prices[i];
           }

        }
        int result=0;
        for(int i=0;i<arr1.length;i++)
        {
            if(arr1[i]+arr2[i]>result)
            {
                result=arr1[i]+arr2[i];
            }
        }

        return result;


    }
}
