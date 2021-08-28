class Solution {
    public int maximumGap(int[] nums) {
        int ans=0;
        if(nums.length<2)
        {
            ans=0;
        }
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]-nums[i-1]>ans)
            {
                ans=nums[i]-nums[i-1];
            }
        }
        
        return ans;
        
    }
}
