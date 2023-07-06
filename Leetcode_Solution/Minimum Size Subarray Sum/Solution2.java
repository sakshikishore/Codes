class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int p=0,sum=0;
        int result=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            sum=sum+nums[i];
            if(sum>=s)
            {
                if((i+1)-p<result)
                {
                    result=(i+1)-p;
                }
                while(sum>=s)
                {
                    sum=sum-nums[p];
                    p++;
                    if(sum>=s)
                    {
                        if((i+1)-p<result)
                        {
                            result=(i+1)-p;
                        }
                    }
                    
                }
            }
        }
        if(result==Integer.MAX_VALUE)
        {
            result=0;
        }
        return result;
        
    }
}
