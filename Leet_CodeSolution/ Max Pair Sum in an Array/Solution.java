class Solution {
    public int maxSum(int[] nums) {
        int result=-1;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                int x=nums[i];
                int maxi=0;
                while(x!=0)
                {
                    int r=x%10;
                    if(r>maxi)
                    {
                        maxi=r;
                    }
                    x=x/10;
                }
                
                int y=nums[j];
                int maxj=0;
                while(y!=0)
                {
                    int r=y%10;
                    if(r>maxj)
                    {
                        maxj=r;
                    }
                    y=y/10;
                }
                if(maxi==maxj)
                {
                    int sum=nums[i]+nums[j];
                    if(sum>result)
                    {
                        result=sum;
                    }
                }
                
            }
        }
        
        return result;
        
    }
}
