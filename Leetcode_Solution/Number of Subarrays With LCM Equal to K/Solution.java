class Solution {
    public int subarrayLCM(int[] nums, int k) {
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            int lcm=nums[i];
            for(int j=i;j<nums.length;j++)
            {
                if(i==j)
                {
                    if(lcm==k)
                    {
                        count++;
                    }
                }
                else
                {
                    int a=lcm,b=nums[j];
                    while(b!=0)
                    {
                        int r=a%b;
                        a=b;
                        b=r;
                    }
                    lcm=(lcm*nums[j])/a;
                    if(lcm==k)
                    {
                        count++;
                    }
                    
                }
            }
        }
        
        return count;
    }
}
