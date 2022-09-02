class Solution {
    public long minimalKSum(int[] nums, int k) {
        long sum=0;
        Arrays.sort(nums);
        long count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(i==0)
            {
                long a=nums[i]-1;
                if(a!=0)
                {
                    if(a>k)
                    {
                        a=k;
                    }
                   sum=(a*(a+1))/2;
                   count=a;
                   if(count==k)
                   {
                       break;
                   }
                }
            }
            else
            {
                long n=nums[i]-nums[i-1]-1;
                if(n>0)
                {
                    if((count+n)>k)
                    {
                        n=k-count;
                    }
                    long a=nums[i-1]+1;
                    a=a*2;
                    sum+=(n*(a+n-1))/2;
                    count+=n;
                    if(count==k)
                    {
                        break;
                    }
                }
                
            }
        }
        if(count!=k)
        {
            long a=nums[nums.length-1]+1;
            long n=k-count;
            a=a*2;
            sum+=(n*(a+n-1))/2;
        }
        return sum;
    }
}
