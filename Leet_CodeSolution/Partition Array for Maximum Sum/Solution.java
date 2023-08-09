class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[]=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            if(i==0)
            {
              dp[i]=arr[i];
            }
            else
            {
                  int max=arr[i];
                  int count=0;
                  for(int j=i;j>=0 && j>=i-k+1;j--)
                  {
                       count++;
                       if(max<arr[j])
                       {
                           max=arr[j];
                       } 
                       int p=count*max;
                       if(j==0)
                       {
                           if(p>dp[i])
                           {
                               dp[i]=p;
                           }
                           continue;
                       }
                       if(p+dp[j-1]>dp[i])
                       {
                           dp[i]=p+dp[j-1];
                       }
                  }
            }
        }

        return dp[dp.length-1];
    }
}
