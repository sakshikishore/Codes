class Solution {
    public int maximumTastiness(int[] price, int k) {
        int ans=0;
        Arrays.sort(price);
        int low=0;
        int high=price[price.length-1]-price[0];
        while(low<=high)
        {
            int mid=(low+high)/2;
            int prev=0;
            int count=0;
            for(int i=1;i<price.length;i++)
            {
                if(price[i]-price[prev]>=mid)
                {
                    count++;
                    prev=i;
                    if(count==k-1)
                    {
                        break;
                    }
                }
            }
            if(count==k-1)
            {
                ans=mid;
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }

        return ans;
    }
}
