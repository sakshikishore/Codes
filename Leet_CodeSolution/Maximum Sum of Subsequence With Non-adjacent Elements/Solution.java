class Solution {
    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        long sum=0;
        for(int i=0;i<queries.length;i++)
        {
            nums[queries[i][0]]=queries[i][1];
            int a=nums[0],b=0;
            for(int j=1;j<nums.length;j++)
            {
                int p=nums[j]+b;
                p=Math.max(b,p);
                b=Math.max(a,b);
                a=p;
            }
            sum+=Math.max(a,b);
        }
        sum=sum%(1000000007);
        return (int)sum;
    }
}
