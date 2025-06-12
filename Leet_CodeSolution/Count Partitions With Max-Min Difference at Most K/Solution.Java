class Solution {
    public int countPartitions(int[] nums, int k) {
        long dp[]=new long[nums.length];
        dp[0]=1l;
        long sum=1l;
        ArrayList<Integer> l=new ArrayList<Integer>();
        l.add(nums[0]);
        int start=0;
        for(int i=1;i<nums.length;i++)
        {
            int low=0,high=l.size()-1;
            while(low<=high)
            {
                int mid=(low+high)/2;
                if(l.get(mid)>nums[i])
                {
                    high=mid-1;
                }
                else
                {
                    low=mid+1;
                }
            }
            l.add(low,nums[i]);
            while(l.size()>1 && l.get(l.size()-1)-l.get(0)>k)
            {
                 low=0;
                 high=l.size()-1;
                 while(low<=high)
                 {
                    int mid=(low+high)/2;
                    if(l.get(mid)==nums[start])
                    {
                        l.remove(mid);
                        if(dp[start]>sum)
                        {
                            sum=sum+(1000000007);
                        }
                        sum=sum-dp[start];
                        break;
                    }
                    if(l.get(mid)>nums[start])
                    {
                        high=mid-1;
                    }
                    else
                    {
                        low=mid+1;
                    }
                 }
                 start++;
            }
            if(l.size()==1)
            {
                 dp[i]=dp[i-1];
                 sum=dp[i];
            }
            else
            {
                if(start==0)
                {
                    dp[i]=sum+1l;
                    sum=sum+dp[i];
                }
                else
                {
                    dp[i]=sum+dp[start-1];
                    sum=sum+dp[i];
                }
            }
            dp[i]=dp[i]%(1000000007);
            sum=sum%1000000007;
        }
        return (int)(dp[dp.length-1]);
    }
}
