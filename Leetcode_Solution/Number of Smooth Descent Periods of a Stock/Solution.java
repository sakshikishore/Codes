class Solution {
    public long getDescentPeriods(int[] prices) {
        long count=0;
        long l=1;
        if(prices.length==1)
        {
            count=1;
        }
        else
        {
        for(int i=0;i<prices.length-1;i++)
        {
            if(prices[i]-prices[i+1]==1)
            {
                l++;
            }
            else
            {
                if(i+1==prices.length-1)
                {
                    count++;
                }
                count=count+(l*(l+1))/2;
                l=1;
            }
        }
        }
        
        if(l>1)
        {
             count=count+(l*(l+1))/2;
        }
        
        return count;
    }
}
