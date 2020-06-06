class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int a=0;
        int count=0;
        int result=0;
        for(int i=0;i<nums.length;i++)
        {
            a=a+nums[i];
            if(a>=s)
            {
                result=i+1;
                break;
            }
            int k=0;
            int sum=a;
            for(int j=i+1;j<nums.length;j++)
            {
                sum=sum-nums[k]+nums[j];
                k++;
                if(sum>=s)
                {
                    result=i+1;
                    count++;
                    break;
                }
            }
            if(count==1)
            {
                break;
            }
        }
        
        return result;
        
    }
}
