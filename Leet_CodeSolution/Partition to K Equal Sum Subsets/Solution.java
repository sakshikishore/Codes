class Solution {
    boolean result=false;
    public void Solve(int nums[],int k,int sum,int n,int dp[][],int count,int p)
    {
        if(result)
        {
            return;
        }
        if(dp[k][p]!=0)
        {
            return;
        }
        dp[k][p]=1;
        if(sum%n==0 && sum==count*n)
        {
            k--;
            count++;
            if(k==0)
            {
                result=true;
                return;
            }
            else
            {
                Solve(nums,k,sum,n,dp,count,p);
                return;
            }
        }
        
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=-1)
            {
                if(sum+nums[i]<=(n*count))
                {
                    int temp=nums[i];
                    nums[i]=-1;
                   Solve(nums,k,sum+temp,n,dp,count,p+(int)Math.pow(2,i)); 
                   nums[i]=temp;
                }
            }
        }
        
    }
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(k==1)
        {
            return true;
        }
        int s=0,sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        if(sum%k==0)
        {
            for(int i=0;i<16;i++)
            {
                s+=Math.pow(2,i);
            }
            int dp[][]=new int[k+1][s+1];
            int n=sum/k;
            Solve(nums,k,0,n,dp,1,0);
        }

        return result;

    }
}
