class Solution {
    public long minTime(int[] skill, int[] mana) {
        long dp[] = new long[skill.length];
        for (int i = 0; i < mana.length; i++) {
            if (i == 0) {
                for (int j = 0; j < skill.length; j++) {
                    if (j == 0) {
                        dp[j] = (1l*mana[i]) * skill[j];
                    } else {
                        dp[j] = mana[i] * skill[j];
                        dp[j] = dp[j] + dp[j - 1];
                    }
                }
            } else {
                long sum = 0;
                long time=dp[0];
                for(int j=0;j<dp.length;j++)
                {
                     sum = sum + (mana[i] * skill[j]);
                     if(j+1<dp.length && sum+time<dp[j+1])
                     {
                       long x= dp[j+1]-(sum+time);
                        time=time+x;
                     }
                }
                sum=time;
                for (int j = 0; j < dp.length; j++) {
                    sum = sum + (mana[i] * skill[j]);
                    dp[j] = sum;
                }
            }
        }

        return dp[dp.length - 1];

    }
}
