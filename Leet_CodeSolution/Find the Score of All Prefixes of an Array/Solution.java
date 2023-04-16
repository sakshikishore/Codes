class Solution {
    public long[] findPrefixScore(int[] nums) {
        long result[]=new long[nums.length];
        long max=0;
        for(int i=0;i<nums.length;i++)
        {
            long p=nums[i];
            if(p>max)
            {
                max=p;
            }
            if(i==0)
            {
                result[0]=2*p;
            }
            else
            {
                result[i]=result[i-1]+(p+max);
            }
        }
        
        return result;
    }
}
