class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int result=0;
        int p=nums[0];
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]-p>k)
            {
                result++;
                p=nums[i];      
            }
        }
        
        result++;
        return result;
    }
}
