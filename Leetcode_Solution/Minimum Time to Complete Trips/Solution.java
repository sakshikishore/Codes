class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        if(time.length==1)
        {
            long t=time[0];
           return (t*totalTrips);
        }
        long min=Integer.MAX_VALUE;
        for(int i=0;i<time.length;i++)
        {
            if(time[i]<min)
            {
                min=time[i];
            }
        }
        
        long max=totalTrips*min;
        long result=min;
        while(min<=max)
        {
            long mid=(min+max)/2;
            long count=0;
            for(int j=0;j<time.length;j++)
            {
                count=count+(mid/time[j]);
            }
            if(count>=totalTrips)
            {
                max=mid-1;
                result=mid;
            }
            else
            {
                min=mid+1;
            }
        }
        
        return result;
    }
}
