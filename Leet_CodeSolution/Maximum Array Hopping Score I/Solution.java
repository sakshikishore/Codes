class Solution {
    public int maxScore(int[] nums) {
        int res[]=new int[nums.length];
        for(int i=nums.length-2;i>=0;i--)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                int p=nums[j]*(j-i)+res[j];
                if(p>res[i])
                {
                    res[i]=p;
                }
            }
        }

        return res[0];
    }
}
