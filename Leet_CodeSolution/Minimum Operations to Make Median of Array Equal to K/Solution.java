class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        long ans=0;
        Arrays.sort(nums);
        int mid=nums.length/2;
        if(nums[mid]==k)
        {
            return 0;
        }
        int j=mid-1;
        while(j>=0 && nums[j]>k)
        {
            ans+=nums[j]-k;
            j--;
        }
        if(nums[mid]<k)
        {
            ans+=k-nums[mid];
        }
        else
        {
            ans+=nums[mid]-k;
        }
        if(nums[mid]<k)
        {
            j=mid+1;
            while(j<nums.length && nums[j]<k)
            {
                ans+=k-nums[j];
                j++;
            }
        }
        
        return ans;
    }
}
