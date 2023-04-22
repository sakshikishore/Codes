class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        long dp[]=new long[n+1];
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<rides.length;i++)
        {
            if(!h.containsKey(rides[i][1]))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(i);
                h.put(rides[i][1],l);
            }
            else
            {
                ArrayList<Integer> l=h.get(rides[i][1]);
                l.add(i);
                h.put(rides[i][1],l);
            }
        }
        for(int i=1;i<=n;i++)
        {
            if(!h.containsKey(i))
            {
                dp[i]=dp[i-1];
            }
            else
            {
                ArrayList<Integer> l=h.get(i);
                long max=0;
                for(int j=0;j<l.size();j++)
                {
                    int k=l.get(j);
                    int start=rides[k][0];
                    long score=(i-start+rides[k][2])+dp[start];
                    if(score>max)
                    {
                        max=score;
                    }

                }

                dp[i]=max;
                if(dp[i]<dp[i-1])
                {
                    dp[i]=dp[i-1];
                }
            }

        }

        return dp[n];
    }
}
