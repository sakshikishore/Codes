class Solution {
    public long maxProduct(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<0)
            {
                nums[i]=nums[i]*(-1);
            }
        }
        Arrays.sort(nums);

        long result=nums[nums.length-1]*1l;
        return result*(100000)*nums[nums.length-2];
    }
}
