class Solution {
    public int sumFourDivisors(int[] nums) {
        int totalSum=0;
        for(int i=0;i<nums.length;i++)
        {
            int count=2;
            int sum=1+nums[i];
            for(int j=2;j<=(nums[i])/2;j++)
            {
                if(nums[i]%j==0)
                {
                    count++;
                    sum=sum+j;
                    if(count>4)
                    {
                        break;
                    }
                }
            }
            if(count==4)
            {
               totalSum+=sum;
            }
        }
        
        return totalSum;
    }
}
