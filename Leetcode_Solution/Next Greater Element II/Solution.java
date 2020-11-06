class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int result[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            result[i]=-1;
        }
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length+i;j++)
            {
                if(nums[j%nums.length]>nums[i])
                {
                    result[i]=nums[j%nums.length];
                    break;
                }
            }
        }
        
        return result;
        
    }
}
