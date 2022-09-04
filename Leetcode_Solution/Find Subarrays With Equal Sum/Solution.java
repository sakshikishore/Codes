class Solution {
    public boolean findSubarrays(int[] nums) {
        for(int i=0;i<nums.length-1;i++)
        {
            int sum=nums[i]+nums[i+1];
            for(int j=i+1;j<nums.length-1;j++)
            {
                int x=nums[j]+nums[j+1];
                if(x==sum)
                {
                    return true;
                }
            }
        }
        
        return false;
    }
}
