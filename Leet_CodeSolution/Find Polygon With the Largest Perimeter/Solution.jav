class Solution {
    public long largestPerimeter(int[] nums) {
        long ans=0;
        Arrays.sort(nums);
        long sum[]=new long[nums.length];
        sum[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            sum[i]=sum[i-1]+nums[i];
        }
        for(int i=nums.length-2;i>=0;i--)
        {
            if(i<1)
            {
                break;
            }
            if(sum[i]>nums[i+1])
            {
                return sum[i+1];
            }
        }
        
        return -1;
    }
}
