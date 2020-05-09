class Solution {
    public int majorityElement(int[] nums) {
      Arrays.sort(nums);
        int max=1;
        int count=1;
        int result=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i]==nums[i-1])
            {
                count++;
            }
            else
            {
                if(count>max)
                {
                    max=count;
                    result=nums[i-1];
                }
                count=1;
            }
        }
               if(count>max)
                {
                    max=count;
                    result=nums[nums.length-1];
                }
        return result;
        
    }
}
