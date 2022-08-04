class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int j=0;
        int p=1,prod=1;
        int result=0;
        int count=1;
        for(int i=0;i<nums.length;i++)
        {
            int x=0;
            if(prod==1)
            {
                x=1;
            }
            else
            {
             x=prod/p;
            }

            if(count>0)
            {
                count--;
            }
            else
            {
                count=0;
            }
            int flag=0;
            if(j<i)
            {
                j=i;
            }
            for(int t=j;t<nums.length;t++)
            {
                x=x*nums[t];
                if(x<k)
                {
                    count++;
                }
                else
                {
                    flag=1;
                    x=x/nums[t];
                    if(count>0)
                    {
                      result+=count;
                    }
                    j=t;
                    p=nums[i];
                    break;
                }
            }
            if(flag==0)
            {
                int n=nums.length-i;
                int sum=(n*(n+1))/2;
                result+=sum;
                break;
            }
             prod=x;
        }
        return result;
    }
}
