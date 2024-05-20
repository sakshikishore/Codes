class Solution {
    public long sumDigitDifferences(int[] nums) {
        long ans=0;
        String s=Integer.toString(nums[0]);
        int c[][]=new int[s.length()][10];
        for(int i=0;i<nums.length;i++)
        {
            int p=0;
            while(nums[i]>0)
            {
                int r=nums[i]%10;
                c[p][r]++;
                nums[i]=nums[i]/10;
                p++;
            }
        }
        for(int i=0;i<s.length();i++)
        {
            for(int j=0;j<10;j++)
            {
                for(int k=j+1;k<10;k++)
                {
                    ans+=c[i][j]*c[i][k];
                }
            }
        }
        
        return ans;
    }
}
