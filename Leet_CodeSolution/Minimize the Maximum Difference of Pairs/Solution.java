class Solution {
    public int minimizeMax(int[] nums, int p) {
        if(nums.length==1)
        {
            return 0;
        }
        int ans=0;
        Arrays.sort(nums);
        int low=0,high=nums[nums.length-1]-nums[0];
        while(low<=high)
        {
            int mid=(low+high)/2;
            int i=1;
            int count=0;
            while(i<nums.length)
            {
                if(nums[i]-nums[i-1]<=mid)
                {
                    count++;
                    i=i+2;
                }
                else
                {
                    i++;
                }
            }
            if(count>=p)
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }

        return ans;


    }
}
