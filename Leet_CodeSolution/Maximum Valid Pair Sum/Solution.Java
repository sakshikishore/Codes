class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int result=0;
        int max[]=new int[nums.length];
        for(int i=nums.length-1;i>=0;i--)
        {
            if(i==nums.length-1)
            {
                max[i]=nums[i];
            }
            else
            {
                max[i]=Math.max(nums[i],max[i+1]);
            }
        }
        for(int i=0;i<nums.length-1;i++)
        {
            if(i+k<nums.length)
            {
                result=Math.max(result,nums[i]+max[i+k]);
            }
            else
            {
                break;
            }
        }

        return result;
    }
}
