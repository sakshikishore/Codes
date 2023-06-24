class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        for(int i=0;i<ages.length;i++)
        {
            for(int j=i+1;j<ages.length;j++)
            {
                if(ages[i]>ages[j])
                {
                    int temp=ages[i];
                    ages[i]=ages[j];
                    ages[j]=temp;

                    temp=scores[i];
                    scores[i]=scores[j];
                    scores[j]=temp;

                }
                else if(ages[i]==ages[j] && scores[i]>scores[j])
                {
                    int temp=ages[i];
                    ages[i]=ages[j];
                    ages[j]=temp;

                    temp=scores[i];
                    scores[i]=scores[j];
                    scores[j]=temp;
                }
            }
        }
        int dp[]=new int[ages.length];
        dp[0]=scores[0];
        int max=dp[0];
        for(int i=1;i<ages.length;i++)
        {
            dp[i]=scores[i];
            for(int j=i-1;j>=0;j--)
            {
                if(scores[j]<=scores[i])
                {
                    if(dp[j]+scores[i]>dp[i])
                    {
                        dp[i]=dp[j]+scores[i];
                    }
                }
            }

            if(dp[i]>max)
            {
                max=dp[i];
            }
        }
        return max;

    }
}
