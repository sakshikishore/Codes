class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long ans=0;
        
        for(int k=0;k<maxHeights.size();k++)
        {
                long sum=0;
                int prev=maxHeights.get(k);
                for(int i=k-1;i>=0;i--)
                {
                   prev=Math.min(prev,maxHeights.get(i));
                   sum+=prev;
                }
                prev=maxHeights.get(k);
                for(int i=k+1;i<maxHeights.size();i++)
                {
                   prev=Math.min(prev,maxHeights.get(i));
                   sum+=prev;
                }

                sum+=maxHeights.get(k);
            if(sum>ans)
            {
                ans=sum;
            }
        }
        
        return ans;
    }
}
