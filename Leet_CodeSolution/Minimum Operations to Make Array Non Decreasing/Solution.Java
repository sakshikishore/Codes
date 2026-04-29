class Solution {
    public long minOperations(int[] nums) {
       long sum=0;
       for(int i=1;i<nums.length;i++)
       {
         if(nums[i]<nums[i-1])
         {
            sum+=nums[i-1]-nums[i];
         }
       }

       return sum;

    }
}
