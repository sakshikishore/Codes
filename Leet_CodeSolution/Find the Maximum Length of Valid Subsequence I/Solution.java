class Solution {
    public int maximumLength(int[] nums) {
        int countEven=0,countOdd=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]%2==0)
            {
                countEven++;
            }
            else
            {
                countOdd++;
            }
        }

        int max=Math.max(countEven,countOdd);

        // case even odd even ..
        int count=0;
        int flag=0;
        for(int i=0;i<nums.length;i++)
        {
            if(flag==0)
            {
                if(nums[i]%2==0)
                {
                    count++;
                    flag=1;
                }
            }
            else
            {
                if(nums[i]%2!=0)
                {
                    count++;
                    flag=0;
                }
            }
        }

        max=Math.max(max,count);
         // case odd even odd ..
         count=0;
         flag=0;
        for(int i=0;i<nums.length;i++)
        {
            if(flag==0)
            {
                if(nums[i]%2!=0)
                {
                    count++;
                    flag=1;
                }
            }
            else
            {
                if(nums[i]%2==0)
                {
                    count++;
                    flag=0;
                }
            }
        }

         max=Math.max(max,count);

         return max;
    }
}
