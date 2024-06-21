class Solution {
    public int maxDistance(int[] position, int m) {
        int ans=0;
        Arrays.sort(position);
        int high=position[position.length-1]-position[0];
        int low=0;
        while(low<=high)
        {
            int mid=(low+high)/2;
            int prev=0;
            int count=1;
            for(int i=1;i<position.length;i++)
            {
                if(position[i]-position[prev]>=mid)
                {
                    count++;
                    if(count==m)
                    {
                        break;
                    }
                    prev=i;
                }
            }
            if(count==m)
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
