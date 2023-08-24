class Solution {
    public int minimizeArrayValue(int[] nums) {
        long low=nums[0];
        long high=nums[0];
        long ans=0;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]>high)
            {
                high=nums[i];
            }
            if(nums[i]<low)
            {
                low=nums[i];
            }
        }

        while(low<=high)
        {
            int arr[]=new int[nums.length];
            long mid=(low+high)/2;
            int flag=0;
            long sum=0;
            for(int i=0;i<nums.length;i++)
            {
                 sum+=nums[i];
                 if(sum>(i+1)*mid)
                 {
                     flag=1;
                     break;
                 }
            }
            if(flag==1)
            {
                low=mid+1;
            }
            else
            {
                ans=mid;
                high=mid-1;
            }
        }

        return (int)ans;
    }
}
