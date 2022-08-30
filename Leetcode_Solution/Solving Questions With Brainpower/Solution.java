class Solution {
    public long mostPoints(int[][] questions) {
        long dp[]=new long[questions.length];
        dp[dp.length-1]=questions[questions.length-1][0];
        long arr[]=new long[questions.length]; // for storing max value
        arr[dp.length-1]=questions[questions.length-1][0];
        long max=dp[dp.length-1];
        for(int i=questions.length-2;i>=0;i--)
        {
            int x=questions[i][1];
            if((x+i+1)<questions.length)
            {
                dp[i]=questions[i][0]+arr[x+i+1];
            }
            else
            {
                dp[i]=questions[i][0];
            }
            if(dp[i]>max)
            {
                max=dp[i];
            }
            if(dp[i]>arr[i+1])
            {
                arr[i]=dp[i];
            }
            else
            {
                arr[i]=arr[i+1];
            }
        }
        
        return max;
    }
}
