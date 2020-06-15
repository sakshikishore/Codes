class Solution {
    public int[] finalPrices(int[] prices) {
        int arr[]=new int[prices.length];
       arr[prices.length-1]= prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--)
        {
            int index=0;
            int count=0;
            for(int j=i+1;j<prices.length;j++)
            {
                if(prices[j]<=prices[i])
                {
                    index=j;
                    count++;
                    break;
                }
            }
            if(count==0)
            {
                arr[i]=prices[i];
            }
            else
            {
                arr[i]=prices[i]-prices[index];
            }
        }
        
        return arr;
        
    }
}
