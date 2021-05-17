class Solution {
    public int subsetXORSum(int[] nums) {
        int sum=0;
        for(int i=0;i<(1<<nums.length);i++)
        {
            int a=0;
            for(int j=0;j<nums.length;j++)
            {
                if((i&(1<<j))>0)
                {
                    a=a^nums[j];
                }
            }
            sum=sum+a;
        }
        
        return sum;
    }
}
