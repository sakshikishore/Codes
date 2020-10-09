class Solution {
    public int search(int[] nums, int target) {
        int result=-1;
        int low=0;
        int high=nums.length-1;
        while(high>=low)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]==target)
            {
                result=mid;
                break;
            }
            else if(target>nums[mid])
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
        }
        
        return result;
        
    }
}
