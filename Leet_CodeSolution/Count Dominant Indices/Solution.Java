class Solution {
    public int dominantIndices(int[] nums) {
        int result=0;
        double sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        double s=0;
        for(int i=0;i<nums.length-1;i++)
        {
            s+=nums[i];
            if(((sum-s)/(nums.length-i-1))<nums[i])
            {
                result++;
            }
        }


        return result;
    }
}
