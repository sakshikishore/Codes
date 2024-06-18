class Solution {
    double max=0.0;
    public double Solve(int nums[],int k,int index,double dp[][])
    {
         if(index==nums.length)
         {
            return 0.0;
         }
         double s=0.0;
         double a=0.0;
         if(dp[index][k]!=-1)
         {
            return dp[index][k];
         }
         if(k==1)
         {
             for(int i=index;i<nums.length;i++)
             {
                s+=nums[i];
             }
              a=s/(nums.length-index)+Solve(nums,0,nums.length,dp);
         }
         else
         {
            for(int i=index;i<=nums.length-k;i++)
            {
                s+=nums[i];
                a=Math.max(a,s/(i-index+1)+Solve(nums,k-1,i+1,dp));
            }
         }
        return  dp[index][k]=a;
    }
    public double largestSumOfAverages(int[] nums, int k) {
        double dp[][]=new double[nums.length][k+1];
        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return Solve(nums,k,0,dp);
    }
}
