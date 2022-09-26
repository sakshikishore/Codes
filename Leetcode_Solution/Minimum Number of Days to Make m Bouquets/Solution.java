class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k>bloomDay.length)
        {
            return -1;
        }
        int result=0;
        int min=Integer.MAX_VALUE,max=0;
        for(int i=0;i<bloomDay.length;i++)
        {
            if(bloomDay[i]<min)
            {
                min=bloomDay[i];
            }
            if(bloomDay[i]>max)
            {
                max=bloomDay[i];
            }
        }
        
        while(min<=max)
        {
            int mid=(min+max)/2;
             int count=0;
             int totalbouquets=0;
             for(int i=0;i<bloomDay.length;i++)
             {
                 if(bloomDay[i]<=mid)
                 {
                     count++;
                 }
                 else
                 {
                     totalbouquets+=count/k;
                     count=0;
                 }
             }
             totalbouquets+=count/k;
             if(totalbouquets>=m)
             {
                 result=mid;
                 max=mid-1;
             }
            else
            {
                min=mid+1;
            }
        }
        
        return result;
    }
}
