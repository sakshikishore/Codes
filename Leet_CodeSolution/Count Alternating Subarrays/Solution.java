class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long ans=0;
        long count=1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]!=nums[i-1])
            {
                count++;
            }
            else
            {
                ans+=((count)*(count+1))/2;
                count=1;
            }
        }
        
         ans+=((count)*(count+1))/2;
        
        return ans;
    }
}
