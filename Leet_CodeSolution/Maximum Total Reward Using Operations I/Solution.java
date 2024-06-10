class Solution {
    public int Solve(int arr[],int index,int sum, int dp[][])
    {
        if(sum>=arr[arr.length-1] || index==arr.length)
        {
            return sum;
        }
        if(dp[index][sum]!=-1)
        {
            return dp[index][sum];
        }
        int a=Solve(arr,index+1,sum,dp);
        int b=sum;
        if(arr[index]>sum)
        {
            b=Solve(arr,index+1,sum+arr[index],dp);
        }

        return dp[index][sum]=Math.max(a,b);
    }

    public int maxTotalReward(int[] rewardValues) {
        int dp[][]=new int[rewardValues.length][4000];
        for(int i=0;i<dp.length;i++)
        {
           Arrays.fill(dp[i],-1);
        }
        Arrays.sort(rewardValues);
        return Solve(rewardValues,0,0,dp);
        
    }
}
