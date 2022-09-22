class Solution {
    public int shipWithinDays(int[] weights, int days) {
       int sum=0,max=0;
        for(int i=0;i<weights.length;i++)
        {
          sum+=weights[i];
          if(weights[i]>max)
          {
              max=weights[i];
          }
        }
        
        int high=sum,low=max;
        int result=0;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int capacity=0;
            int totaldays=1;
            for(int j=0;j<weights.length;j++)
            {
                if(weights[j]+capacity>mid)
                {
                    totaldays++;
                    capacity=weights[j];
                }
                else
                {
                    capacity+=weights[j];
                }
            }
            if(totaldays>days)
            {
                low=mid+1;
            }
            else
            {
                result=mid;
                high=mid-1;
            }
        }
        
        return result;
        
    }
}
