class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int dp[][]=new int[nums1.length+1][nums2.length+1];
        for(int i=0;i<nums1.length;i++)
        {
            for(int j=0;j<nums2.length;j++)
            {
                if(nums1[i]==nums2[j])
                {
                    dp[i+1][j+1]=1+dp[i][j];
                }
                else
                {
                    dp[i+1][j+1]=(int)Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }

        return dp[nums1.length][nums2.length];
    }
}
