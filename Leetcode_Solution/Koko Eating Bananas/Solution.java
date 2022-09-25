class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;
        for(int i=0;i<piles.length;i++)
        {
            if(piles[i]>max)
            {
                max=piles[i];
            }
        }
        
        int min=1;
        int result=0;
        while(min<=max)
        {
            int mid=(min+max)/2;
            double m=mid;
            int hours=0;
            for(int j=0;j<piles.length;j++)
            {
                hours+=Math.ceil(piles[j]/m);
            }
            if(hours>h)
            {
                min=mid+1;
            }
            else
            {
                result=mid;
                max=mid-1;
            }
            
        }
        
        return result;
    }
}
