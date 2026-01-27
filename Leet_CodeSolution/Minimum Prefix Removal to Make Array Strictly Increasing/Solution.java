class Solution {
    public int minimumPrefixLength(int[] nums) {
        int ans=1;
        for(int i=nums.length-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                ans++;
            }
            else
            {
                break;
            }
        }

        return nums.length-ans;
    }
}
