class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long result=0;
        for(int i=0;i<nums.length;i++)
        {
            int x=lower-nums[i];
            int y=upper-nums[i];
            int min=0,max=0;
            int low=0,high=nums.length-1;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(nums[mid]>=x)
                {
                    min=mid;
                    high=mid-1;
                }
                else
                {
                    min=mid+1;
                    low=mid+1;
                }
            }
            low=0;
            high=nums.length-1;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(nums[mid]>y)
                {
                    max=mid;
                    high=mid-1;
                }
                else
                {
                    max=mid+1;
                    low=mid+1;
                }
            }
            if(min>i && max>i)
            {
                result+=max-min;
            }
            else
            {
                if(max<=i)
                {
                    continue;
                }
                else
                {
                    min=i+1;
                    result+=max-min;
                }
            }

        }

        return result;
    }
}
