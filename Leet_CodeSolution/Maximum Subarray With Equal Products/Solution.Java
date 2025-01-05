class Solution {
    public int maxLength(int[] nums) {
        int ans=1;
        for(int i=0;i<nums.length;i++)
            {
                int lcm=nums[i],gcd=nums[i];
                int prod=nums[i];
                for(int j=i+1;j<nums.length;j++)
                    {
                        prod=prod*nums[j];
                        int a=lcm,b=nums[j];
                     while(b>0)
                     {
                        int r=a%b;
                        a=b;
                        b=r;
                     }
                     lcm=(lcm*nums[j])/a;

                    a=gcd;
                    b=nums[j];
                     while(b>0)
                     {
                        int r=a%b;
                        a=b;
                        b=r;
                     }
                     gcd=a;

                      if(gcd*lcm==prod)
                      {
                          ans=Math.max(ans,j-i+1);
                      }
                    }          
            }

        return ans;
    }
}
