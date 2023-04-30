class Solution {
    public int maximumCandies(int[] candies, long k) {
        int ans=0;
        long sum=0;
        for(int i=0;i<candies.length;i++)
        {
            sum+=candies[i];
        }
        long min=0,max=sum/k;
        while(min<=max)
        {
            long mid=(min+max)/2;
            long result=0;
            if(mid==0)
            {
                min=mid+1;
                continue;
            }
            
            for(int i=0;i<candies.length;i++)
            {
                result+=(candies[i])/mid;
                if(result>=k)
                {
                    break;
                }
            }
            if(result>=k)
            {
                 ans=(int)mid;
                 min=mid+1;
            }
            else
            {
                max=mid-1;
            }
        }

        return ans;
    }
}
