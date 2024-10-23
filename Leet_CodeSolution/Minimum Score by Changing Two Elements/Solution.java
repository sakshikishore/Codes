class Solution {
    public int minimizeSum(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==3)
        {
            return 0;
        }
        int min=nums[nums.length-1]-nums[2];
        if(nums[nums.length-2]-nums[1]<min)
        {
            min=nums[nums.length-2]-nums[1];
        }
        if(nums[nums.length-3]-nums[0]<min)
        {
            min=nums[nums.length-3]-nums[0];
        }

        return min;
    }
}
