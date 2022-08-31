class Solution {
    public int minimumAverageDifference(int[] nums) {
        long totalSum=0;
        int result=0;
        long min=Long.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            totalSum+=nums[i];
        }
        long leftSum=0;
        for(int i=0;i<nums.length;i++)
        {
            leftSum+=nums[i];
            long rightSum=totalSum-leftSum;
            long leftAvg=Math.round(leftSum/(i+1));
            long rightAvg=0;
            if(i!=nums.length-1)
            {
                rightAvg=Math.round(rightSum/(nums.length-i-1));
            }
            long absoluteDiff=Math.abs(leftAvg-rightAvg);
            if(absoluteDiff<min)
            {
                min=absoluteDiff;
                result=i;
            }
            
        }
        
        return result;
    }
}
