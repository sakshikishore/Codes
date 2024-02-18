class Solution {
    public int maxOperations(int[] nums) {
        int result=1;
        int sum=nums[0]+nums[1];
        for(int i=3;i<nums.length;i=i+2)
        {
            if(nums[i]+nums[i-1]==sum)
            {
                result++;
            }
            else
            {
                break;
            }
        }
        
        return result;
    }
}
