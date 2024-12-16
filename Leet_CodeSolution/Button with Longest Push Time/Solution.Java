class Solution {
    public int buttonWithLongestTime(int[][] events) {
        int maxTime=events[0][1];
        int ans=events[0][0];
        for(int i=1;i<events.length;i++)
            {
                int t=events[i][1]-events[i-1][1];
                if(t>maxTime)
                {
                    maxTime=t;
                    ans=events[i][0];
                }
                else if(t==maxTime)
                {
                    ans=Math.min(ans,events[i][0]);
                }
                
            }

        return ans;
    }
}
