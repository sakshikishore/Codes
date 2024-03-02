class Solution {
    public int minOperations(int[] nums, int k) {
        int count=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<k)
            {
                count++;
            }
            else
            {
                break;
            }
        }
        
        return count;
    }
}
