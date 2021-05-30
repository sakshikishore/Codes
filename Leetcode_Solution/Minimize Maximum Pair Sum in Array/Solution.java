class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max=0;
        for(int i=0;i<nums.length/2;i++)
        {
            if(nums[nums.length-i-1]+nums[i]>max)
            {
                max= nums[nums.length-i-1]+nums[i];
            }
        }
        
        return max;
    }
}
