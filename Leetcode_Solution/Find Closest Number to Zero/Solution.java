class Solution {
    public int findClosestNumber(int[] nums) {
        int min=100001;
        int result=0;
        for(int i=0;i<nums.length;i++)
        {
            int x=nums[i];
            int p=(int)Math.abs(nums[i]);
            if(p<min)
            {
                min=p;
                result=x;
            }
            if(p==min)
            {
                if(result<x)
                {
                    result=x;
                }
            }
        }
        
        return result;
    }
}
