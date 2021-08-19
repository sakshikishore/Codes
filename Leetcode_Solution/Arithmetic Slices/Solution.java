class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int result=0;
        for(int i=0;i<nums.length;i++)
        {
            int count=1;
            for(int j=i+1;j<nums.length;j++)
            {
                count++;
                if(count>2)
                {
                    if(nums[j]-nums[j-1]==nums[j-1]-nums[j-2])
                    {
                        result++;
                    }
                    else
                    {
                        break;
                    }
                }
                
                
            }
        }
        
        return result;
        
    }
}
