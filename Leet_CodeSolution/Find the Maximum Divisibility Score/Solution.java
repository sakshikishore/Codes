class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int maxScore=0;
        int result=divisors[0];
        for(int i=0;i<divisors.length;i++)
        {
            int count=0;
            for(int j=0;j<nums.length;j++)
            {
                if(nums[j]%divisors[i]==0)
                {
                    count++;
                }
            }
            if(count==maxScore)
            {
                result=Math.min(result,divisors[i]);
            }
            else
            {
                if(count>maxScore)
                {
                    maxScore=count;
                    result=divisors[i];
                }
            }
        }
        
        return result;
    }
}
