class Solution {
    public int maximumTop(int[] nums, int k) {
        if(k==0)
        {
            return nums[0];
        }
        if(k>nums.length)
        {
            if(nums.length==1)
            {
                if(k%2==0)
                {
                    return nums[0];
                }
                else
                {
                    return -1;
                }
            }
            int max=0;
            for(int i=0;i<nums.length;i++)
            {
                if(nums[i]>max)
                {
                    max=nums[i];
                }
            }
            return max;
        }
        if(k==1 && nums.length==1)
        {
            return -1;
        }
        else
        {
            if(k==1)
            {
                return nums[1];
            }
            Arrays.sort(nums,0,k-1);
            if(k<nums.length)
            {
                if(nums[k]>nums[k-2])
                {
                    return nums[k];
                }
            }
            return nums[k-2];
        }
    }
}
