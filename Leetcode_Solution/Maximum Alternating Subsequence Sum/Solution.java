class Solution {
    int min=Integer.MIN_VALUE;
    long dp[][]=new long[100001][2];
    public long solve(int[] nums, int flag, int i)
        {
            if(i==nums.length)
            {
                return 0;
            }
            if(dp[i][flag]!=min)
            {
                return dp[i][flag];
            }
            long s1=solve(nums,flag,i+1); // In case we are not including the element
            long s2=0;
            if(flag==0)
            {
                s2=s2+nums[i]+solve(nums,1-flag,i+1);
            }
            else
            {
                s2=s2-nums[i]+solve(nums,1-flag,i+1);
            }
            
            return dp[i][flag]=(long)Math.max(s1,s2);
        }
    public long maxAlternatingSum(int[] nums) {
        for(int i=0;i<dp.length;i++)
        {
            dp[i][0]=min;
            dp[i][1]=min;
        }
        return solve(nums,0,0);
    }
}
