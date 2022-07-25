class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==nums[i-1])
            {
                count++;
                nums[i]=nums[i]+1;
            }
            else if(nums[i]<nums[i-1])
            {
                int x=nums[i-1]+1;
                count=count+x-nums[i];
                nums[i]=x;
            }
        }
        
        return count;
    }
}
