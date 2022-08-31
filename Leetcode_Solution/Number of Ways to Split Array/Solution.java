class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum=0;
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        long leftsum=0;
        for(int j=0;j<nums.length-1;j++)
        {
            leftsum+=nums[j];
            long rightsum=sum-leftsum;
            if(rightsum<=leftsum)
            {
                count++;
            }
            
        }
        
        return count;
    }
}
