class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if(dist.length-1<hour)
        {
            int min=1;
            int max=10000000;
            int result=0;
            while(min<=max)
            {
                int mid=(min+max)/2;
                double speed=mid;
                double totalTime=0.0;
                for(int i=0;i<dist.length-1;i++)
                {
                    totalTime+=Math.ceil(dist[i]/speed);
                }
                totalTime+=dist[dist.length-1]/speed;
                if(totalTime<=hour)
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
        else
        {
            return -1;
        }
    }
}
