class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total=0;
        int l=0;
        if(timeSeries.length>0)
        {
            total=duration;
            l=timeSeries[0]+duration;
        for(int i=1;i<timeSeries.length;i++)
        {
            if(timeSeries[i]>=l)
            {
                 total+=duration;
                 l=timeSeries[i]+duration;
            }
            else
            {
                int p=timeSeries[i]+duration;
                total=total+(p-l);
                l=p;
                
            }
        }
        }
        return total;
    }
}
