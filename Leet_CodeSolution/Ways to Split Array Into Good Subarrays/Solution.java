class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        int prev=-1;
        long result=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==1)
            {
                if(prev==-1)
                {
                    prev=i;
                    result=1;
                }
                else
                {
                    int r=i-prev-1;
                    result=result+(result*r);
                    result=result%(1000000007);
                    prev=i;
                }
            }
        }
        
        return (int)result;
        
    }
}
