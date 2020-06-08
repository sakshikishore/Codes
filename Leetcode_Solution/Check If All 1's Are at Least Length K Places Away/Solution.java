class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        boolean result=true;
        int count=0;
        int prev_position=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==1)
            {
                if(count==0)
                {
                    count++;
                    prev_position=i;
                }
                else
                {
                    if(i-prev_position<=k)
                    {
                        result=false;
                        break;
                    }
                    prev_position=i;
                }
            }
            
        }
        
        return result;
        
    }
}
