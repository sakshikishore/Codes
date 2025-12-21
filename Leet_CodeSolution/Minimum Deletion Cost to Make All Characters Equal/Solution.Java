class Solution {
    public long minCost(String s, int[] cost) {
        long ans=Long.MAX_VALUE;
        for(int i=0;i<26;i++)
        {
            long val=0;
            boolean flag=false;
            for(int j=0;j<s.length();j++)
            {
                if((s.charAt(j)-'a')!=i)
                {
                    val+=cost[j];
                }
                else
                {
                    flag=true;
                }
            }
            if(flag)
            {
                ans=Math.min(ans,val);
            }
        }

        return ans;
    }
}
