class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        Arrays.sort(nums);
        int min=1,max=nums[nums.length-1];
        int result=max;
        if(threshold==nums.length)
        {
            return max;
        }
        else
        {
            int prev=-1;
            while(min<=max)
            {
                int mid=(min+max)/2;
                int sum=0;
                double m=mid;
                for(int i=0;i<nums.length;i++)
                {
                    sum=sum+(int)Math.ceil(nums[i]/m);
                }
                if(sum<=threshold)
                {
                    max=mid-1;
                    result=mid;
                }
                else
                {
                    min=mid+1;
                }
            }
        }
        
        return result;
    }
}
