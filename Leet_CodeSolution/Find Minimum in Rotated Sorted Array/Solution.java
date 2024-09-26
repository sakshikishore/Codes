class Solution {
    public int findMin(int[] nums) {
       if(nums.length==1)
      {
            return nums[0];
      }
      if(nums.length==2)
      {
        return Math.min(nums[0],nums[1]);
      }
        int low=0,high=nums.length-1;
        while(low<=high)
        {
            if(high-low==1)
            {
                return Math.min(nums[high],nums[low]);
            }
            else if(high==low)
            {
                return nums[high];
            }
            int mid=(low+high)/2;
            if(nums[mid]<nums[mid-1])
            {
                return nums[mid];
            }
            else if(nums[mid]>nums[mid+1])
            {
                return nums[mid+1];
            }
            else if(nums[mid]>nums[mid-1] && nums[mid]<nums[mid+1])
            {
                if(nums[mid-1]>nums[high])
                {
                    low=mid+1;
                }
                else
                {
                    high=mid-1;
                }
            }
        }

        return 0;
    }
}
