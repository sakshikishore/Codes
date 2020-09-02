class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        boolean result=false;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<=i+k && j<nums.length;j++)
            {
                if((nums[i]==Integer.MAX_VALUE && nums[j]<0) || (nums[j]==Integer.MAX_VALUE && nums[i]<0))
                {
                    result=false;
                }
               else if(Math.abs(nums[i]-nums[j])<=t)
                {
                    result=true;
                    break;
                }
            }
        }
        
        return result;
        
    }
}
