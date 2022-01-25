class Solution {
    public int countElements(int[] nums) {
        int count=0;
        Arrays.sort(nums);
        for(int i=1;i<nums.length-1;i++)
        {
            if(nums[i]>nums[0] && nums[i]<nums[nums.length-1])
            {
                count++;
            }
        }
        
        return count;
        
    }
}
