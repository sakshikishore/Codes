class Solution {
    public int minStartValue(int[] nums) {
        int x=0;
        int sum=1;
        if(nums[0]>0)
        {
                sum=nums[0];
        }
         else
         {
               x=Math.abs(nums[0])+1;
              
         }
        for(int i=1;i<nums.length;i++)
        {
           
          if(sum+nums[i]<=0)
           {
             x=x+Math.abs(sum+nums[i])+1;
             sum=1;
           }
            
            else
            {
                sum=sum+nums[i];
            }
        }
        
        if(x==0)
        {
            x=1;
        }
        return x;
        
    }
}
