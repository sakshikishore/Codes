class Solution {
    public int minimumOperations(List<Integer> nums) {
        int count=0;
        int dp[]=new int[nums.size()];
        dp[0]=1;
        int max=1;
        for(int i=1;i<nums.size();i++)
        {
            dp[i]=1;
           for(int j=i-1;j>=0;j--)
           {
               if(nums.get(i)>=nums.get(j))
               {
                   if(dp[j]+1>dp[i])
                   {
                       dp[i]=dp[j]+1;
                   }
               }
           }
            if(dp[i]>max)
            {
                max=dp[i];
            }
        }
       
        
        return nums.size()-max;
    }
}
