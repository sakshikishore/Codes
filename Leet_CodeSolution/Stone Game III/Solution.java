class Solution {
    int dp[]=new int[50001];
    public int Solution(int[] stoneValue,int index,int[] dp)
    {
         if(index>=stoneValue.length)
         {
             return 0;
         }
         if(dp[index]!=-1)
         {
             return dp[index];
         }
         int ans=Integer.MIN_VALUE;
         ans=stoneValue[index]-Solution(stoneValue,index+1,dp);
         if(index+1<stoneValue.length)
         {
             ans=Math.max(ans,stoneValue[index]+stoneValue[index+1]-Solution(stoneValue,index+2,dp));
         }
         if(index+2<stoneValue.length)
         {
             ans=ans=Math.max(ans,stoneValue[index]+stoneValue[index+1]+stoneValue[index+2]-Solution(stoneValue,index+3,dp));
         }

         return dp[index]=ans;
    }
    public String stoneGameIII(int[] stoneValue) {
        for(int i=0;i<dp.length;i++)
        {
            dp[i]=-1;
        }
        int val=Solution(stoneValue,0,dp);
        if(val==0)
        {
            return "Tie";
        }
        if(val<0)
        {
            return "Bob";
        }
       
       return "Alice";
    }
}
