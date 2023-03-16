class Solution {
    public int searchInsert(int[] nums, int target) {
        int min=0;
        int max=nums.length-1;
        int result=0;
        while(min<=max)
        {
            int mid=(min+max)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            else if(nums[mid]>target)
            {
                result=mid;
                max=mid-1;
            }
            else
            {
                result=mid+1;
                min=mid+1;
            }
        }

        return result;
    }
}
