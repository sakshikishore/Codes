class Solution {
    public int differenceOfSum(int[] nums) {
        int eleSum=0,digSum=0;
        for(int i=0;i<nums.length;i++)
        {
            eleSum+=nums[i];
            while(nums[i]>0)
            {
                int r=nums[i]%10;
                digSum+=r;
                nums[i]=nums[i]/10;
            }
        }
        
        return Math.abs(eleSum-digSum);
    }
}
