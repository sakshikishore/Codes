class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long result=0;
        long a=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                a++;
            }
            else
            {
                result+=((a)*(a+1))/2;
                a=0;
            }
        }
        if(a>0)
        {
             result+=((a)*(a+1))/2;
        }
        
        return result;
    }
}
