class Solution {
    public long maxScore(int[] nums) {
        long max=0;
       for(int i=0;i<nums.length;i++)
       {
        int flag=0;
        long gcd=0,lcm=0;
         for(int j=0;j<nums.length;j++)
         {
               if(i==j)
               {
                continue;
               }
               else
               {
                 if(flag==0)
                 {
                    gcd=nums[j];
                    lcm=nums[j];
                    flag=1;
                 }
                 else
                 {
                     long  a=gcd,b=nums[j];
                     while(b>0)
                     {
                        long r=a%b;
                        a=b;
                        b=r;
                     }
                     gcd=a;
                     a=lcm;
                     b=nums[j];
                     while(b>0)
                     {
                        long r=a%b;
                        a=b;
                        b=r;
                     }

                     lcm=(lcm*nums[j])/a;
                    
                 }
               }
         }
         if(lcm*gcd>max)
         {
            System.out.println(lcm+" ||  "+gcd);
            max=lcm*gcd;
         }
       }
        long gcd=nums[0],lcm=nums[0];
         for(int j=1;j<nums.length;j++)
         {
                    long a=lcm,b=nums[j];
                     while(b>0)
                     {
                        long r=a%b;
                        a=b;
                        b=r;
                     }
                     lcm=(lcm*nums[j])/a;

                    a=gcd;
                    b=nums[j];
                     while(b>0)
                     {
                        long r=a%b;
                        a=b;
                        b=r;
                     }
                     gcd=a;


                      
         }
         if(lcm*gcd>max)
         {
            max=lcm*gcd;
         }
        
       return max;
         
    }
}
