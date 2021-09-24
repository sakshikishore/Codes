class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int sum1=0,sum2=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            sum1=sum1+nums[i];
            sum2=sum2+nums[i];
            if(sum1>max)
            {
                max=sum1;
            }
            if(Math.abs(sum2)>max)
            {
                max=Math.abs(sum2);
            }
            if(sum1<0)
            {
                sum1=0;
            }
            if(sum2>0)
            {
                sum2=0;
            }
        }
        
        return max;
    }
}
