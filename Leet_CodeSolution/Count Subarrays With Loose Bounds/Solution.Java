class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans=0;
        long count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>=minK && nums[i]<=maxK)
            {
                count++;
            }
            else
            {
                ans+=(count)*(count+1)/2;
                count=0;
            }
        }

        ans+=(count)*(count+1)/2;

        return ans;
    }
}
