class Solution {
    public int minOperations(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(count%2==0)
            {
                if(nums[i]==0)
                {
                    count++;
                }
            }
            else
            {
                if(nums[i]==1)
                {
                    count++;
                }
            }
        }
        
        return count;
    }
}
